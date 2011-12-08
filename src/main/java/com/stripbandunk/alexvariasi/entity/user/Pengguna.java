/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity.user;

import com.stripbandunk.alexvariasi.entity.AbstractEntity;
import com.stripbandunk.alexvariasi.entity.master.Karyawan;
import com.stripbandunk.alexvariasi.view.render.NamaGrupTableCellRenderer;
import com.stripbandunk.alexvariasi.view.render.NamaKaryawanTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_pengguna")
public class Pengguna extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    @TableColumn(number = 1, name = "Kode Karyawan")
    private String id;
    
    @Column(name = "kata_sandi")
    private String kataSandi;
    
    @Column(name="aktif", nullable=false)
    private boolean aktif;
    
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    @TableColumn(number = 2, name = "Nama Karyawan", size = 20, renderer = NamaKaryawanTableCellRenderer.class)
    private Karyawan karyawan;
    
    @ManyToOne
    @JoinColumn(name = "id_grup", nullable = false)
    @TableColumn(number = 3, name = "Grup", renderer = NamaGrupTableCellRenderer.class)
    private Grup grup;

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }

    public Grup getGrup() {
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public String getKataSandi() {
        return kataSandi;
    }

    public void setKataSandi(String kataSandi) {
        this.kataSandi = kataSandi;
    }
}
