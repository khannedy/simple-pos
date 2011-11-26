/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.validator.impl;

import com.stripbandunk.alexvariasi.entity.user.Pengguna;
import com.stripbandunk.alexvariasi.validator.AbstractValidator;
import com.stripbandunk.alexvariasi.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class PenggunaValidator extends AbstractValidator<Pengguna> {

    @Override
    protected void doValidate(Pengguna data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Pengguna tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Kode pengguna tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Kode pengguna tidak boleh kosong");
        } else if (data.getKataSandi() == null) {
            throwValidatorException("Kata sandi pengguna tidak boleh null");
        } else if (data.getKataSandi().trim().isEmpty()) {
            throwValidatorException("Kata sandi pengguna tidak boleh kosong");
        } else if (data.getGrup() == null) {
            throwValidatorException("Grup pengguna tidak boleh null");
        } else if (data.getKaryawan() == null) {
            throwValidatorException("Karyawan pengguna tidak boleh null");
        }
    }
}
