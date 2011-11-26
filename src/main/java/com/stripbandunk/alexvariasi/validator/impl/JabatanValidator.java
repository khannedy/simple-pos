/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.validator.impl;

import com.stripbandunk.alexvariasi.entity.master.Jabatan;
import com.stripbandunk.alexvariasi.validator.AbstractValidator;
import com.stripbandunk.alexvariasi.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class JabatanValidator extends AbstractValidator<Jabatan> {

    @Override
    protected void doValidate(Jabatan data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Jabatan tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Id jabatan tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Id jabatan tidak boleh kosong");
        } else if (data.getNama() == null) {
            throwValidatorException("Nama jabatan tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama jabatan tidak boleh kosong");
        }
    }
}
