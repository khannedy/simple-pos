/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.service.impl;

import com.github.khannedy.simplepos.entity.master.Kategori;
import com.github.khannedy.simplepos.service.AbstractService;
import com.github.khannedy.simplepos.service.KategoriService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Service
public class KategoriServiceImpl extends AbstractService<Kategori, String> implements KategoriService {

    public KategoriServiceImpl() {
        super(Kategori.class);
    }
}
