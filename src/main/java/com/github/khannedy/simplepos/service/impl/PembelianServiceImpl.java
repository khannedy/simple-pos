/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.khannedy.simplepos.service.impl;

import com.github.khannedy.simplepos.entity.Pengaturan;
import com.github.khannedy.simplepos.entity.master.DetailBarang;
import com.github.khannedy.simplepos.entity.report.Jurnal;
import com.github.khannedy.simplepos.entity.transaction.DetailPembelian;
import com.github.khannedy.simplepos.entity.transaction.Pembelian;
import com.github.khannedy.simplepos.service.JurnalService;
import com.github.khannedy.simplepos.service.PembelianService;
import com.github.khannedy.simplepos.service.PengaturanService;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author echo
 */
@Service
public class PembelianServiceImpl implements PembelianService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PengaturanService pengaturanService;

    @Autowired
    private JurnalService jurnalService;

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public void save(Pembelian pembelian) {
        Session session = currentSession();
        session.save(pembelian);
        for (DetailPembelian detailPembelian : pembelian.getDaftarPembelian()) {
            DetailBarang detailBarang = detailPembelian.getDetailBarang();
            detailBarang.setStok(detailBarang.getStok() + detailPembelian.getJumlah());
            session.update(detailBarang);
        }

        Pengaturan pengaturan = pengaturanService.find("saldo-terakhir");
        long saldo = pengaturan.getNilaiLong() - pembelian.getTotal();

        Jurnal jurnal = new Jurnal();
        jurnal.setKredit(pembelian.getTotal());
        jurnal.setDebit(0L);
        jurnal.setNama("Pembelian : No " + pembelian.getId() + " Dari " + pembelian.getPemasok().getNama());
        jurnal.setSaldo(saldo);
        jurnal.setSaldoSebelumnya(pengaturan.getNilaiLong());
        jurnal.setWaktu(pembelian.getWaktuTransaksi());

        pengaturan.setNilaiLong(saldo);
        pengaturanService.update(pengaturan);

        jurnalService.save(jurnal);
    }

    @Override
    @Transactional
    public List<Pembelian> findAll(Date from, Date to) {
        Session session = currentSession();
        return session.createQuery("select a from Pembelian a where date(a.waktuTransaksi) between date(:from) and date(:to)").
                setDate("from", from).setDate("to", to).list();
    }
}
