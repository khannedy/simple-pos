/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.validator.impl;

import com.github.khannedy.simplepos.entity.master.Pelanggan;
import com.github.khannedy.simplepos.validator.AbstractValidator;
import com.github.khannedy.simplepos.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class PelangganValidator extends AbstractValidator<Pelanggan> {

    @Override
    protected void doValidate(Pelanggan data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Pelanggan tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Id pelanggan tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Id pelanggan tidak boleh kosong");
        } else if (data.getNama() == null) {
            throwValidatorException("Nama pelanggan tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama pelanggan tidak boleh kosong");
        }
    }
}
