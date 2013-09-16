/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.entity.user;

import com.github.khannedy.simplepos.entity.AbstractEntity;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_hak_akses")
public class HakAkses extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @ManyToMany(mappedBy = "daftarHakAkses")
    private List<Grup> daftarGrup;

    public List<Grup> getDaftarGrup() {
        return Collections.unmodifiableList(daftarGrup);
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
        return nama;
    }
}
