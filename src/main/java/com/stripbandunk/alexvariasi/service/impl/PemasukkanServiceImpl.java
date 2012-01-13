/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.service.impl;

import com.stripbandunk.alexvariasi.entity.Pengaturan;
import com.stripbandunk.alexvariasi.entity.report.Jurnal;
import com.stripbandunk.alexvariasi.entity.transaction.Pemasukkan;
import com.stripbandunk.alexvariasi.service.AbstractService;
import com.stripbandunk.alexvariasi.service.JurnalService;
import com.stripbandunk.alexvariasi.service.PengaturanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author echo
 */
@Service
public class PemasukkanServiceImpl extends AbstractService<Pemasukkan, Long> implements com.stripbandunk.alexvariasi.service.PemasukkanService {

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
