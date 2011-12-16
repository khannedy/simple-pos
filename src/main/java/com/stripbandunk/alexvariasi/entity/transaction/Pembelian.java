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
import com.stripbandunk.alexvariasi.view.render.PemasokTableCellRenderer;
import com.stripbandunk.alexvariasi.view.render.PenggunaTableCellRenderer;
import com.stripbandunk.alexvariasi.view.render.TanggalTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_pembelian")
public class Pembelian extends AbstractTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @TableColumn(number = 1, name = "No Transaksi")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "waktu_transaksi")
    @TableColumn(number = 2, name = "Tanggal", renderer = TanggalTableCellRenderer.class)
    private Date waktuTransaksi;

    @ManyToOne
    @JoinColumn(name = "id_pengguna")
    @TableColumn(number = 3, name = "Pengguna", renderer = PenggunaTableCellRenderer.class)
    private Pengguna pengguna;

    @ManyToOne
    @JoinColumn(name = "id_pemasok")
    @TableColumn(number = 4, name = "Pemasok", renderer = PemasokTableCellRenderer.class)
    private Pemasok pemasok;

    @OneToMany(mappedBy = "pembelian", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailPembelian> daftarPembelian = new ArrayList<>();

    @Column(name = "total")
    @TableColumn(number = 5, name = "Total Pembelian")
    private Long total;

    public Long getTotal() {
        return total;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getWaktuTransaksi() {
        return waktuTransaksi;
    }

    public void setWaktuTransaksi(Date waktuTransaksi) {
        this.waktuTransaksi = waktuTransaksi;
    }

    public void tambahDetailPembelian(DetailPembelian detailPembelian) {
        detailPembelian.setPembelian(this);
        daftarPembelian.add(detailPembelian);
        total = 0l;
        for (DetailPembelian detail : daftarPembelian) {
            total += detail.getSubTotal();
        }
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
