/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @param <T> id
 * @author Eko Kurniawan Khannedy
 */
@MappedSuperclass
public abstract class AbstractEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "waktu_dibuat", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuDibuat;

    @Column(name = "terakhir_dirubah", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date terakhirDirubah;

    @Lob
    @Column(name = "info")
    @TableColumn(number = 100, name = "Keterangan", size = 30)
    private String info;

    public abstract T getId();

    public abstract void setId(T id);

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @SuppressWarnings("ReturnOfDateField")
    public Date getTerakhirDirubah() {
        return terakhirDirubah;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setTerakhirDirubah(Date terakhirDirubah) {
        this.terakhirDirubah = terakhirDirubah;
    }

    @SuppressWarnings("ReturnOfDateField")
    public Date getWaktuDibuat() {
        return waktuDibuat;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setWaktuDibuat(Date waktuDibuat) {
        this.waktuDibuat = waktuDibuat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        final AbstractEntity<T> other = (AbstractEntity<T>) obj;
        if (this.getId() != other.getId() && (this.getId() == null
                || !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }
}
