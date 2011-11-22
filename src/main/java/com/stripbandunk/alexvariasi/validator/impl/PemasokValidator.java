/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.validator.impl;

import com.stripbandunk.alexvariasi.entity.master.Pemasok;
import com.stripbandunk.alexvariasi.validator.AbstractValidator;
import com.stripbandunk.alexvariasi.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class PemasokValidator extends AbstractValidator<Pemasok> {

    @Override
    public void doValidate(Pemasok data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Pemasok tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Id pemasok tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Id pemasok tidak boleh kosong");
        } else if (data.getNama() == null) {
            throwValidatorException("Nama pemasok tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama pemasok tidak boleh kosong");
        }
    }
}
