/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@MappedSuperclass
public class AbstractTransactionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "waktu_transaksi")
    private Date waktuTransaksi;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "waktu_transaksi_diubah")
    private Date waktuTransaksiDiubah;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @SuppressWarnings("ReturnOfDateField")
    public Date getWaktuTransaksi() {
        return waktuTransaksi;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setWaktuTransaksi(Date waktuTransaksi) {
        this.waktuTransaksi = waktuTransaksi;
    }

    @SuppressWarnings("ReturnOfDateField")
    public Date getWaktuTransaksiDiubah() {
        return waktuTransaksiDiubah;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setWaktuTransaksiDiubah(Date waktuTransaksiDiubah) {
        this.waktuTransaksiDiubah = waktuTransaksiDiubah;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractTransactionEntity other = (AbstractTransactionEntity) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
