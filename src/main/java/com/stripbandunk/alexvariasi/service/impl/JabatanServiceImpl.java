/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.service.impl;

import com.stripbandunk.alexvariasi.entity.master.Jabatan;
import com.stripbandunk.alexvariasi.service.AbstractService;
import com.stripbandunk.alexvariasi.service.JabatanService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Service
public class JabatanServiceImpl extends AbstractService<Jabatan, String> implements JabatanService {

    public JabatanServiceImpl() {
        super(Jabatan.class);
    }
}
