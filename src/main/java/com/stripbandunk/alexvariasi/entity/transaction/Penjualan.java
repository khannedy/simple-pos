/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity.transaction;

import com.stripbandunk.alexvariasi.entity.AbstractTransactionEntity;
import com.stripbandunk.alexvariasi.entity.master.Pelanggan;
import com.stripbandunk.alexvariasi.entity.user.Pengguna;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_penjualan")
public class Penjualan extends AbstractTransactionEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_pengguna")
    private Pengguna pengguna;

    @ManyToOne
    @JoinColumn(name = "id_pelanggan", nullable = false)
    private Pelanggan pelanggan;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "penjualan")
    private List<DetailPenjualan> daftarPenjualan = new ArrayList<>();

    @Column(name = "uang")
    private Long uang;

    @Column(name = "total")
    private Long total;

    public Long getTotal() {
        return total;
    }

    public Long getUang() {
        return uang;
    }

    public void setUang(Long uang) {
        this.uang = uang;
    }

    public void tambahDaftarPenjualan(DetailPenjualan detailPenjualan) {
        detailPenjualan.setPenjualan(this);
        daftarPenjualan.add(detailPenjualan);
        total = 0l;
        for (DetailPenjualan detail : daftarPenjualan) {
            total += detail.getSubTotal();
        }
    }

    public void hapusDaftarPenjualan(DetailPenjualan detailPenjualan) {
        detailPenjualan.setPenjualan(null);
        daftarPenjualan.remove(detailPenjualan);
    }

    public List<DetailPenjualan> getDaftarPenjualan() {
        return daftarPenjualan;
    }

    public void setDaftarPenjualan(List<DetailPenjualan> daftarPenjualan) {
        this.daftarPenjualan = daftarPenjualan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }
}
