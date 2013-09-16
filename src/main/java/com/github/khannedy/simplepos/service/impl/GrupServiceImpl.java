/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.service.impl;

import com.github.khannedy.simplepos.entity.user.Grup;
import com.github.khannedy.simplepos.service.AbstractService;
import com.github.khannedy.simplepos.service.GrupService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Service
public class GrupServiceImpl extends AbstractService<Grup, String> implements GrupService {

    public GrupServiceImpl() {
        super(Grup.class);
    }
}
