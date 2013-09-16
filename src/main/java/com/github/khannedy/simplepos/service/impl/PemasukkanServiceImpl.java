/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.khannedy.simplepos.service.impl;

import com.github.khannedy.simplepos.entity.Pengaturan;
import com.github.khannedy.simplepos.entity.report.Jurnal;
import com.github.khannedy.simplepos.entity.transaction.Pemasukkan;
import com.github.khannedy.simplepos.service.AbstractService;
import com.github.khannedy.simplepos.service.JurnalService;
import com.github.khannedy.simplepos.service.PengaturanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author echo
 */
@Service
public class PemasukkanServiceImpl extends AbstractService<Pemasukkan, Long> implements com.github.khannedy.simplepos.service.PemasukkanService {

    @Autowired
    private JurnalService jurnalService;

    @Autowired
    private PengaturanService pengaturanService;

    public PemasukkanServiceImpl() {
        super(Pemasukkan.class);
    }

    @Override
    @Transactional
    public void save(Pemasukkan entity) {
        super.save(entity);

        Pengaturan pengaturan = pengaturanService.find("saldo-terakhir");

        Jurnal jurnal = new Jurnal();
        jurnal.setKredit(0L);
        jurnal.setDebit(entity.getJumlah());
        jurnal.setNama("Pemasukkan : " + entity.getNama());
        jurnal.setWaktu(entity.getWaktuDibuat());
        jurnal.setSaldoSebelumnya(pengaturan.getNilaiLong());

        long saldo = pengaturan.getNilaiLong() + entity.getJumlah();
        pengaturan.setNilaiLong(saldo);

        jurnal.setSaldo(saldo);

        pengaturanService.update(pengaturan);
        jurnalService.save(jurnal);
    }
}
