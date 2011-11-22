/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.service.impl;

import com.stripbandunk.alexvariasi.entity.master.Pelanggan;
import com.stripbandunk.alexvariasi.service.AbstractService;
import com.stripbandunk.alexvariasi.service.PelangganService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Service
public class PelangganServiceImpl extends AbstractService<Pelanggan, String> implements PelangganService {

    public PelangganServiceImpl() {
        super(Pelanggan.class);
    }
}
