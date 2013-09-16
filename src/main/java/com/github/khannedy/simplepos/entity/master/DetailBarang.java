/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.entity.master;

import com.github.khannedy.simplepos.entity.AbstractEntity;
import com.github.khannedy.simplepos.view.render.BarangTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_detail_barang")
public class DetailBarang extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @TableColumn(number = 1, name = "Kode")
    private String id;

    @Column(name = "harga_beli", nullable = false)
    @TableColumn(number = 3, name = "Harga Beli")
    private Long hargaBeli;

    @Column(name = "harga_jual", nullable = false)
    @TableColumn(number = 4, name = "Harga Jual")
    private Long hargaJual;

    @Column(name = "stok", nullable = false)
    @TableColumn(number = 5, name = "Stok")
    private Integer stok;

    @ManyToOne
    @JoinColumn(name = "id_barang", nullable = false)
    @TableColumn(number = 2, name = "Nama", size = 20, renderer = BarangTableCellRenderer.class)
    private Barang barang;

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Barang getBarang() {
        return barang;
    }

    public Long getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(Long hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public Long getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Long hargaJual) {
        this.hargaJual = hargaJual;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }
}
