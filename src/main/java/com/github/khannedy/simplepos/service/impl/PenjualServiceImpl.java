/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.service.impl;

import com.github.khannedy.simplepos.entity.master.Penjual;
import com.github.khannedy.simplepos.service.AbstractService;
import com.github.khannedy.simplepos.service.PenjualService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Service
public class PenjualServiceImpl extends AbstractService<Penjual, String> implements PenjualService {

    public PenjualServiceImpl() {
        super(Penjual.class);
    }
}
