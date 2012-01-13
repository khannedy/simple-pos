/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.service.impl;

import com.stripbandunk.alexvariasi.entity.transaction.Pemasukkan;
import com.stripbandunk.alexvariasi.service.AbstractService;
import org.springframework.stereotype.Service;

/**
 *
 * @author echo
 */
@Service
public class PemasukkanServiceImpl extends AbstractService<Pemasukkan, Long> implements com.stripbandunk.alexvariasi.service.PemasukkanService {

    public PemasukkanServiceImpl() {
        super(Pemasukkan.class);
    }
}
