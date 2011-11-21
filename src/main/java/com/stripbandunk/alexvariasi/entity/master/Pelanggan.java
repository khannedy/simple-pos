/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity.master;

import com.stripbandunk.alexvariasi.entity.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_pelanggan")
public class Pelanggan extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    private String nama;

    @Column(name = "kota", length = 100)
    private String kota;

    @Column(name = "alamat", length = 500)
    private String alamat;

    @Column(name = "telepon", length = 20)
    private String telepon;

    @Column(name = "kodepos", length = 6)
    private String kodePos;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
