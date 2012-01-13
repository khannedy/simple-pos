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
import com.stripbandunk.alexvariasi.view.render.PelangganTableCellRenderer;
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
@Table(name = "tabel_penjualan")
public class Penjualan extends AbstractTransactionEntity {

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
    @JoinColumn(name = "id_pelanggan", nullable = false)
    @TableColumn(number = 4, name = "Pelanggan", renderer = PelangganTableCellRenderer.class)
    private Pelanggan pelanggan;

    @Column(name = "uang")
    private Long uang;

    @Column(name = "total")
    @TableColumn(number = 5, name = "Total Pembelian")
    private Long total;

    @Column(name = "keuntungan")
    private Long keuntungan;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "penjualan")
    private List<DetailPenjualan> daftarPenjualan = new ArrayList<>();

    public Long getKeuntungan() {
        return keuntungan;
    }

    public Date getWaktuTransaksi() {
        return waktuTransaksi;
    }

    public void setWaktuTransaksi(Date waktuTransaksi) {
        this.waktuTransaksi = waktuTransaksi;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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
        long totalBeli = 0l;
        for (DetailPenjualan detail : daftarPenjualan) {
            total += detail.getSubTotal();
            totalBeli += detail.getJumlah() * detail.getDetailBarang().getHargaBeli();
        }
        keuntungan = total - totalBeli;
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
