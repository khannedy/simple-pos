/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.entity.master;

import com.github.khannedy.simplepos.entity.AbstractEntity;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_satuan")
public class Satuan extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @TableColumn(number = 1, name = "Kode")
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    @TableColumn(number = 2, name = "Nama", size = 20)
    private String nama;

    @OneToMany(mappedBy = "satuan")
    private List<Barang> daftarBarang;

    public List<Barang> getDaftarBarang() {
        return Collections.unmodifiableList(daftarBarang);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNama();
    }
}
