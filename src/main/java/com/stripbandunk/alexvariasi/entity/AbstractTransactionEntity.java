/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@MappedSuperclass
public abstract class AbstractTransactionEntity extends AbstractAutoIdEntity {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "waktu_transaksi_diubah")
    private Date waktuTransaksiDiubah;

    @SuppressWarnings("ReturnOfDateField")
    public Date getWaktuTransaksiDiubah() {
        return waktuTransaksiDiubah;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setWaktuTransaksiDiubah(Date waktuTransaksiDiubah) {
        this.waktuTransaksiDiubah = waktuTransaksiDiubah;
    }
}
