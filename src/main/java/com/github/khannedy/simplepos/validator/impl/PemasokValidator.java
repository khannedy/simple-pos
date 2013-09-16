/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.validator.impl;

import com.github.khannedy.simplepos.entity.master.Pemasok;
import com.github.khannedy.simplepos.validator.AbstractValidator;
import com.github.khannedy.simplepos.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class PemasokValidator extends AbstractValidator<Pemasok> {

    @Override
    protected void doValidate(Pemasok data) throws ValidatorException {
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
