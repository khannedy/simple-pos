/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.report;

import com.stripbandunk.alexvariasi.entity.master.Pelanggan;
import com.stripbandunk.alexvariasi.entity.master.Pemasok;
import com.stripbandunk.alexvariasi.entity.transaction.Pembelian;
import com.stripbandunk.alexvariasi.entity.transaction.Penjualan;
import com.stripbandunk.alexvariasi.entity.user.Pengguna;
import com.stripbandunk.alexvariasi.view.render.PelangganTableCellRenderer;
import com.stripbandunk.alexvariasi.view.render.PemasokTableCellRenderer;
import com.stripbandunk.alexvariasi.view.render.PenggunaTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.Date;

/**
 *
 * @author echo
 */
public class Keuntungan {

    @TableColumn(number = 1, name = "No Transaksi")
    private Long id;

    @TableColumn(number = 2, name = "Jenis Transaksi")
    private String jenis;

    @TableColumn(number = 3, name = "Tanggal")
    private Date tanggal;

    @TableColumn(number = 4, name = "Pengguna", renderer = PenggunaTableCellRenderer.class)
    private Pengguna pengguna;

    @TableColumn(number = 5, name = "Pelanggan", renderer = PelangganTableCellRenderer.class)
    private Pelanggan pelanggan;

    @TableColumn(number = 6, name = "Pemasok", renderer = PemasokTableCellRenderer.class)
    private Pemasok pemasok;

    @TableColumn(number = 7, name = "Total Transaksi")
    private Long total;

    @TableColumn(number = 8, name = "Keuntungan")
    private Long keuntungan;

    public Keuntungan(Penjualan penjualan) {
        this.id = penjualan.getId();
        this.jenis = "Penjualan";
        this.pelanggan = penjualan.getPelanggan();
        this.pemasok = null;
        this.pengguna = penjualan.getPengguna();
        this.tanggal = penjualan.getWaktuTransaksi();
        this.total = penjualan.getTotal();
    }

    public Keuntungan(Pembelian pembelian) {
        this.id = pembelian.getId();
        this.jenis = "Pembelian";
        this.pelanggan = null;
        this.pemasok = pembelian.getPemasok();
        this.pengguna = pembelian.getPengguna();
        this.tanggal = pembelian.getWaktuTransaksi();
        this.total = pembelian.getTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Long getKeuntungan() {
        return keuntungan;
    }

    public void setKeuntungan(Long keuntungan) {
        this.keuntungan = keuntungan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
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

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
