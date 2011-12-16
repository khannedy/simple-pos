/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity.transaction;

import com.stripbandunk.alexvariasi.entity.AbstractTransactionEntity;
import com.stripbandunk.alexvariasi.entity.master.Pemasok;
import com.stripbandunk.alexvariasi.entity.user.Pengguna;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_pembelian")
public class Pembelian extends AbstractTransactionEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Pengguna pengguna;

    private Pemasok pemasok;
}
