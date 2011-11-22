/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.validator.impl;

import com.stripbandunk.alexvariasi.entity.master.Penjual;
import com.stripbandunk.alexvariasi.validator.AbstractValidator;
import com.stripbandunk.alexvariasi.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class PenjualValidator extends AbstractValidator<Penjual> {

    @Override
    public void doValidate(Penjual data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Penjual tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Id penjual tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Id penjual tidak boleh kosong");
        } else if (data.getNama() == null) {
            throwValidatorException("Nama penjual tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama penjual tidak boleh kosong");
        }
    }
}
