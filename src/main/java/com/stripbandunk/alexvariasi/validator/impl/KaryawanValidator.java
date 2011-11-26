/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.validator.impl;

import com.stripbandunk.alexvariasi.entity.master.Karyawan;
import com.stripbandunk.alexvariasi.validator.AbstractValidator;
import com.stripbandunk.alexvariasi.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class KaryawanValidator extends AbstractValidator<Karyawan> {

    @Override
    protected void doValidate(Karyawan data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Karyawan tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Id karyawan tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Id karyawan tidak boleh kosong");
        } else if (data.getNama() == null) {
            throwValidatorException("Nama karyawan tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama karyawan tida boleh kosong");
        } else if (data.getJabatan() == null) {
            throwValidatorException("Jabatan karyawan tidak boleh null");
        } else if (data.getTanggalMasuk() == null) {
            throwValidatorException("Tanggal masuk karyawan tidak boleh null");
        }
    }
}
