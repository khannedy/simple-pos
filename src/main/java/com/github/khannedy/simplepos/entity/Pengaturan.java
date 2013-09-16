/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.khannedy.simplepos.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Serializable
 *
 * @author echo
 */
@Entity
@Table(name = "tabel_pengaturan")
public class Pengaturan implements Serializable {

    @Id
    @Column(name = "kode")
    private String kode;

    @Column(name = "nilai_long")
    private Long nilaiLong;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public Long getNilaiLong() {
        return nilaiLong;
    }

    public void setNilaiLong(Long nilaiLong) {
        this.nilaiLong = nilaiLong;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pengaturan other = (Pengaturan) obj;
        if (!Objects.equals(this.kode, other.kode)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.kode);
        return hash;
    }
}
