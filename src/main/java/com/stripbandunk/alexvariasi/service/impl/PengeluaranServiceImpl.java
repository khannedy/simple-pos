/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.service.impl;

import com.stripbandunk.alexvariasi.entity.transaction.Pengeluaran;
import com.stripbandunk.alexvariasi.service.AbstractService;
import com.stripbandunk.alexvariasi.service.PengeluaranService;
import org.springframework.stereotype.Service;

/**
 *
 * @author echo
 */
@Service
public class PengeluaranServiceImpl extends AbstractService<Pengeluaran, Long> implements PengeluaranService {

    public PengeluaranServiceImpl() {
        super(Pengeluaran.class);
    }
}
