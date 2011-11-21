/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.entity.user;

import com.stripbandunk.alexvariasi.entity.AbstractEntity;
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
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    private String nama;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tabel_join_grup_dan_hak_akses", joinColumns =
    @JoinColumn(name = "id_grup", nullable = false), inverseJoinColumns =
    @JoinColumn(name = "id_hak_akses", nullable = false))
    private List<HakAkses> daftarHakAkses;

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

    public List<HakAkses> getDaftarHakAkses() {
        return Collections.unmodifiableList(daftarHakAkses);
    }
}
