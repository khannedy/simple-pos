/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.service;

import com.stripbandunk.alexvariasi.entity.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @param <T> entity
 * @param <ID> id
 * @author Eko Kurniawan Khannedy
 */
public abstract class AbstractService<T extends AbstractEntity<?>, ID extends Serializable>
        implements Service<T, ID> {

    private SessionFactory sessionFactory;

    @SuppressWarnings("ProtectedField")
    protected Class<T> clazz;

    public AbstractService(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void save(T entity) {
        currentSession().save(entity);
    }

    @Transactional
    public void update(T entity) {
        currentSession().update(entity);
    }

    @Transactional
    public void remove(T entity) {
        currentSession().delete(entity);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public T find(ID id) {
        return (T) currentSession().get(clazz, id);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return currentSession().createCriteria(clazz).list();
    }
}
