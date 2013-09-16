/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.service.impl;

import com.github.khannedy.simplepos.entity.user.Pengguna;
import com.github.khannedy.simplepos.service.AbstractService;
import com.github.khannedy.simplepos.service.PenggunaService;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Service
public class PenggunaServiceImpl extends AbstractService<Pengguna, String> implements PenggunaService {

    public PenggunaServiceImpl() {
        super(Pengguna.class);
    }

    @Transactional(readOnly = true)
    public boolean contains(String id, String kataSandi) {
        Long count = (Long) currentSession().createCriteria(clazz).
                setProjection(Projections.count("id")).add(Restrictions.eq("id", id)).
                add(Restrictions.eq("kataSandi", kataSandi)).setMaxResults(1).uniqueResult();
        return count > 0;
    }
}
