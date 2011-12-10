/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.service.impl;

import com.stripbandunk.alexvariasi.entity.master.Barang;
import com.stripbandunk.alexvariasi.entity.master.DetailBarang;
import com.stripbandunk.alexvariasi.service.AbstractService;
import com.stripbandunk.alexvariasi.service.DetailBarangService;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Service
public class DetailBarangServiceImpl extends AbstractService<DetailBarang, String> implements DetailBarangService {

    public DetailBarangServiceImpl() {
        super(DetailBarang.class);
    }

    @Override
    @Transactional
    public List<DetailBarang> findAll(Barang barang) {
        return currentSession().createCriteria(DetailBarang.class).
                add(Restrictions.eq("barang", barang)).list();
    }
}
