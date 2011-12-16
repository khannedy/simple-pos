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

    @ManyToOne
    @JoinColumn(name = "id_pembelian")
    private Pembelian pembelian;

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_detail_barang", nullable = false)
    private DetailBarang detailBarang;

    @Column(name = "jumlah", nullable = false)
    private Integer jumlah;

    @Transient
    private Long subTotal;

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
