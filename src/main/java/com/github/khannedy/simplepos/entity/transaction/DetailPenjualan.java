/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.entity.transaction;

import com.github.khannedy.simplepos.entity.AbstractAutoIdEntity;
import com.github.khannedy.simplepos.entity.master.DetailBarang;
import com.github.khannedy.simplepos.view.render.DetailBarangTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import javax.persistence.*;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "detail_penjualan")
public class DetailPenjualan extends AbstractAutoIdEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_detail_barang", nullable = false)
    @TableColumn(number = 1, name = "Barang", size = 20, renderer = DetailBarangTableCellRenderer.class)
    private DetailBarang detailBarang;

    @Column(name = "jumlah", nullable = false)
    @TableColumn(number = 2, name = "Jumlah")
    private Integer jumlah;

    @Transient
    @TableColumn(number = 4, name = "Sub Total")
    private Long subTotal;

    @Column(name = "harga", nullable = false)
    @TableColumn(number = 3, name = "Harga")
    private Long harga;

    @ManyToOne
    @JoinColumn(name = "id_penjualan")
    private Penjualan penjualan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public DetailBarang getDetailBarang() {
        return detailBarang;
    }

    public void setDetailBarang(DetailBarang detailBarang) {
        this.detailBarang = detailBarang;
        this.harga = detailBarang.getHargaJual();
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
        this.subTotal = this.jumlah * harga;
    }

    public Long getSubTotal() {
        return subTotal;
    }
}
