/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.service.impl;

import com.stripbandunk.alexvariasi.entity.user.HakAkses;
import com.stripbandunk.alexvariasi.service.AbstractService;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Service
public class HakAksesService extends AbstractService<HakAkses, String> {

    public HakAksesService() {
        super(HakAkses.class);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<HakAkses> search(String query) {
        return currentSession().createCriteria(clazz).add(Restrictions.eq("name", query)).list();
    }
}
