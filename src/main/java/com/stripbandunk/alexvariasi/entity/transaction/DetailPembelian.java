/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity.transaction;

import com.stripbandunk.alexvariasi.entity.AbstractAutoIdEntity;
import com.stripbandunk.alexvariasi.entity.master.DetailBarang;
import com.stripbandunk.alexvariasi.view.render.DetailBarangTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "detail_pembelian")
public class DetailPembelian extends AbstractAutoIdEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_detail_barang", nullable = false)
    @TableColumn(number = 1, name = "Barang", size = 20, renderer = DetailBarangTableCellRenderer.class)
    private DetailBarang detailBarang;

    @Column(name = "jumlah", nullable = false)
    @TableColumn(number = 2, name = "Jumlah")
    private Integer jumlah;

    @Column(name = "harga", nullable = false)
    @TableColumn(number = 3, name = "Harga")
    private Long harga;

    @Transient
    @TableColumn(number = 4, name = "Sub Total")
    private Long subTotal;

    @ManyToOne
    @JoinColumn(name = "id_pembelian")
    private Pembelian pembelian;

    public Pembelian getPembelian() {
        return pembelian;
    }

    public void setPembelian(Pembelian pembelian) {
        this.pembelian = pembelian;
    }

    public DetailBarang getDetailBarang() {
        return detailBarang;
    }

    public void setDetailBarang(DetailBarang detailBarang) {
        this.detailBarang = detailBarang;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
        this.subTotal = this.jumlah * this.detailBarang.getHargaJual();
    }

    public Long getSubTotal() {
        return subTotal;
    }
}
