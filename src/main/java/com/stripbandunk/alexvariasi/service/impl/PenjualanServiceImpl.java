/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.service.impl;

import com.stripbandunk.alexvariasi.entity.master.DetailBarang;
import com.stripbandunk.alexvariasi.entity.transaction.DetailPenjualan;
import com.stripbandunk.alexvariasi.entity.transaction.Penjualan;
import com.stripbandunk.alexvariasi.service.PenjualanService;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author echo
 */
@Service
public class PenjualanServiceImpl implements PenjualanService {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public void save(Penjualan penjualan) {
        Session session = currentSession();
        session.save(penjualan);
        for (DetailPenjualan detailPenjualan : penjualan.getDaftarPenjualan()) {
            DetailBarang detailBarang = detailPenjualan.getDetailBarang();
            detailBarang.setStok(detailBarang.getStok() - detailPenjualan.getJumlah());
            session.update(detailBarang);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Penjualan> findAll(Date from, Date to) {
        Session session = currentSession();
        return session.createQuery("select a from Penjualan a where date(a.waktuTransaksi) between date(:from) and date(:to)").
                setDate("from", from).setDate("to", to).list();
    }
}
