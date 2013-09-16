/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.khannedy.simplepos.service.impl;

import com.github.khannedy.simplepos.entity.report.Jurnal;
import com.github.khannedy.simplepos.service.JurnalService;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author echo
 */
@Service
public class JurnalServiceImpl implements JurnalService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Jurnal jurnal) {
        sessionFactory.getCurrentSession().save(jurnal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jurnal> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Jurnal.class).list();
    }
}
