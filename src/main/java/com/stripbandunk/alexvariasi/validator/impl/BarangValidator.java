/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.validator.impl;

import com.stripbandunk.alexvariasi.entity.master.Barang;
import com.stripbandunk.alexvariasi.validator.AbstractValidator;
import com.stripbandunk.alexvariasi.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class BarangValidator extends AbstractValidator<Barang> {

    @Override
    protected void doValidate(Barang data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Barang tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Kode barang tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Kode barang tidak boleh kosong");
        } else if (data.getNama() == null) {
            throwValidatorException("Nama barang tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama barang tidak boleh kosong");
        } else if (data.getKategori() == null) {
            throwValidatorException("Kategori barang tidak boleh null");
        } else if (data.getSatuan() == null) {
            throwValidatorException("Satuan barang tidak boleh null");
        }
    }
}
