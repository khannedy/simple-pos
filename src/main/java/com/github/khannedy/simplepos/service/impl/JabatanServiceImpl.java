/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.service.impl;

import com.github.khannedy.simplepos.entity.master.Jabatan;
import com.github.khannedy.simplepos.service.AbstractService;
import com.github.khannedy.simplepos.service.JabatanService;
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
