/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.service.impl;

import com.stripbandunk.alexvariasi.entity.master.DetailBarang;
import com.stripbandunk.alexvariasi.entity.transaction.DetailPembelian;
import com.stripbandunk.alexvariasi.entity.transaction.Pembelian;
import com.stripbandunk.alexvariasi.service.PembelianService;
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
    }
}
