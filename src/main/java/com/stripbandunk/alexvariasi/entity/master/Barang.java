/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity.master;

import com.stripbandunk.alexvariasi.entity.AbstractEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_barang")
public class Barang extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    private String nama;

    @ManyToOne
    @JoinColumn(name = "id_kategori", nullable = false)
    private Kategori kategori;

    @ManyToOne
    @JoinColumn(name = "id_satuan", nullable = false)
    private Satuan satuan;

    @OneToMany(mappedBy = "barang", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailBarang> daftarDetailBarang = new ArrayList<DetailBarang>(1);

    public void tambahDetailBarang(DetailBarang detailBarang) {
        if (!daftarDetailBarang.contains(detailBarang)) {
            daftarDetailBarang.add(detailBarang);
            detailBarang.setBarang(this);
        }
    }

    public void hapusDetailBarang(DetailBarang detailBarang) {
        if (daftarDetailBarang.contains(detailBarang)) {
            daftarDetailBarang.remove(detailBarang);
            detailBarang.setBarang(null);
        }
    }

    public List<DetailBarang> getDaftarDetailBarang() {
        return Collections.unmodifiableList(daftarDetailBarang);
    }

    public Satuan getSatuan() {
        return satuan;
    }

    public void setSatuan(Satuan satuan) {
        this.satuan = satuan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
