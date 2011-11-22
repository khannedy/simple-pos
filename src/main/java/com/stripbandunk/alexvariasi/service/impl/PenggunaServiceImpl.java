/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.service.impl;

import com.stripbandunk.alexvariasi.entity.user.Pengguna;
import com.stripbandunk.alexvariasi.service.AbstractService;
import com.stripbandunk.alexvariasi.service.PenggunaService;
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
