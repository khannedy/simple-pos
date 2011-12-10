/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.service;

import com.stripbandunk.alexvariasi.entity.master.Barang;
import com.stripbandunk.alexvariasi.entity.master.DetailBarang;
import java.util.List;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public interface DetailBarangService extends Service<DetailBarang, String> {

    List<DetailBarang> findAll(Barang barang);
}
