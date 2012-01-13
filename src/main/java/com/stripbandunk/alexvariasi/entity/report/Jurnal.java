/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.entity.report;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author echo
 */
@Entity
@Table(name = "tabel_jurnal")
public class Jurnal implements Serializable {

    @Id
    @GeneratedValue
    @TableColumn(number = 1, name = "No Transaksi")
    private Long id;

    @Column(name = "waktu", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @TableColumn(number = 2, name = "Waktu")
    private Date waktu;

    @Column(name = "nama", nullable = false)
    @TableColumn(number = 3, name = "Keterangan")
    private String nama;

    @Column(name = "debit", nullable = false)
    @TableColumn(number = 4, name = "Debit")
    private Long debit;

    @Column(name = "kredit", nullable = false)
    @TableColumn(number = 5, name = "Kredit")
    private Long kredit;

    @Column(name = "saldo", nullable = false)
    @TableColumn(number = 6, name = "Saldo")
    private Long saldo;

    @Column(name = "saldo_sebelumnya", nullable = false)
    private Long saldoSebelumnya;

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getSaldoSebelumnya() {
        return saldoSebelumnya;
    }

    public void setSaldoSebelumnya(Long saldoSebelumnya) {
        this.saldoSebelumnya = saldoSebelumnya;
    }

    public Long getDebit() {
        return debit;
    }

    public void setDebit(Long debit) {
        this.debit = debit;
    }

    public Long getKredit() {
        return kredit;
    }

    public void setKredit(Long kredit) {
        this.kredit = kredit;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jurnal other = (Jurnal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }
}
