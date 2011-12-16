/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.service;

import com.stripbandunk.alexvariasi.entity.transaction.Pembelian;
import java.util.Date;
import java.util.List;

/**
 *
 * @author echo
 */
public interface PembelianService {

    void save(Pembelian pembelian);

    public List<Pembelian> findAll(Date from, Date to);
}
