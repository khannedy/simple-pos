/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.khannedy.simplepos.service;

import com.github.khannedy.simplepos.entity.transaction.Penjualan;
import java.util.Date;
import java.util.List;

/**
 *
 * @author echo
 */
public interface PenjualanService {

    void save(Penjualan penjualan);
    
    public List<Penjualan> findAll(Date from, Date to);
}
