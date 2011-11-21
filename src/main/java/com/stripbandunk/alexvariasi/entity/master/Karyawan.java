/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity.master;

import com.stripbandunk.alexvariasi.entity.AbstractEntity;
import com.stripbandunk.alexvariasi.entity.user.Pengguna;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_karyawan")
public class Karyawan extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    private String nama;

    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;

    @ManyToOne
    @JoinColumn(name = "id_jabatan", nullable = false)
    private Jabatan jabatan;

    @Column(name = "tanggal_masuk")
    @Temporal(TemporalType.DATE)
    private Date tanggalMasuk;

    @Column(name = "telepon", length = 20)
    private String telepon;

    @Column(name = "kota", length = 100)
    private String kota;

    @Column(name = "alamat", length = 500)
    private String alamat;

    @OneToOne(mappedBy = "karyawan")
    private Pengguna pengguna;

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
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

    @SuppressWarnings("ReturnOfDateField")
    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    @SuppressWarnings("ReturnOfDateField")
    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
