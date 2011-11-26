/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.validator.impl;

import com.stripbandunk.alexvariasi.entity.master.Satuan;
import com.stripbandunk.alexvariasi.validator.AbstractValidator;
import com.stripbandunk.alexvariasi.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class SatuanValidator extends AbstractValidator<Satuan> {

    @Override
    protected void doValidate(Satuan data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Satuan tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Id satuan tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Id satuan tidak boleh kosong");
        } else if (data.getNama() == null) {
            throwValidatorException("Nama satuan tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama satuan tidak boleh kosong");
        }
    }
}
