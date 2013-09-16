/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.service;

import com.github.khannedy.simplepos.entity.user.Pengguna;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public interface PenggunaService extends Service<Pengguna, String> {

    boolean contains(String id, String kataSandi);
}
