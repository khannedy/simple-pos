/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity.user;

import com.stripbandunk.alexvariasi.entity.AbstractEntity;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Entity
@Table(name = "tabel_grup")
public class Grup extends AbstractEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @TableColumn(number = 1, name = "Kode")
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    @TableColumn(number = 20, name = "Nama")
    private String nama;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tabel_join_grup_dan_hak_akses", joinColumns =
    @JoinColumn(name = "id_grup", nullable = false), inverseJoinColumns =
    @JoinColumn(name = "id_hak_akses", nullable = false))
    private List<HakAkses> daftarHakAkses = new ArrayList<>(0);

    @OneToMany(mappedBy = "grup")
    private List<Pengguna> daftarPengguna;

    public List<Pengguna> getDaftarPengguna() {
        return Collections.unmodifiableList(daftarPengguna);
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

    public void tambahHakAkses(HakAkses hakAkses) {
        if (!daftarHakAkses.contains(hakAkses)) {
            daftarHakAkses.add(hakAkses);
        }
    }

    public void hapusHakAkses(HakAkses hakAkses) {
        if (daftarHakAkses.contains(hakAkses)) {
            daftarHakAkses.remove(hakAkses);
        }
    }

    public boolean mengandungHakAkses(HakAksesConstant constant) {
        for (HakAkses akses : daftarHakAkses) {
            if (akses.getId().equals(constant.toString())) {
                return true;
            }
        }
        return false;
    }

    public void hapusSemuaHakAkses() {
        daftarHakAkses.clear();
    }

    public List<HakAkses> getDaftarHakAkses() {
        return Collections.unmodifiableList(daftarHakAkses);
    }

    @Override
    public String toString() {
        return getId() + " - " + getNama();
    }
}
