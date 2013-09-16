/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.validator.impl;

import com.github.khannedy.simplepos.entity.master.Kategori;
import com.github.khannedy.simplepos.validator.AbstractValidator;
import com.github.khannedy.simplepos.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class KategoriValidator extends AbstractValidator<Kategori> {

    @Override
    protected void doValidate(Kategori data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Kategori tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Kode kategori tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Kode kategori tidak boleh kosong");
        } else if (data.getNama() == null) {
            throwValidatorException("Nama kategori tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama kategori tidak boleh kosong");
        }
    }
}
