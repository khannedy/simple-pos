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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_pembelian")
public class Pembelian extends AbstractTransactionEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_pengguna")
    private Pengguna pengguna;

    @ManyToOne
    @JoinColumn(name = "id_pemasok")
    private Pemasok pemasok;

    @OneToMany(mappedBy = "pembelian", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailPembelian> daftarPembelian = new ArrayList<>();

    public void tambahDetailPembelian(DetailPembelian detailPembelian) {
        detailPembelian.setPembelian(this);
        daftarPembelian.add(detailPembelian);
    }

    public void hapusDetailPembelian(DetailPembelian detailPembelian) {
        detailPembelian.setPembelian(null);
        daftarPembelian.remove(detailPembelian);
    }

    public List<DetailPembelian> getDaftarPembelian() {
        return daftarPembelian;
    }

    public void setDaftarPembelian(List<DetailPembelian> daftarPembelian) {
        this.daftarPembelian = daftarPembelian;
    }

    public Pemasok getPemasok() {
        return pemasok;
    }

    public void setPemasok(Pemasok pemasok) {
        this.pemasok = pemasok;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }
}
