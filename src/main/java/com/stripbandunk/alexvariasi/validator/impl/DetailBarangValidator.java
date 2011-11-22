/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.validator.impl;

import com.stripbandunk.alexvariasi.entity.master.DetailBarang;
import com.stripbandunk.alexvariasi.validator.AbstractValidator;
import com.stripbandunk.alexvariasi.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class DetailBarangValidator extends AbstractValidator<DetailBarang> {

    @Override
    public void doValidate(DetailBarang data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Detail barang tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Id barang tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Id barang tidak boleh kosong");
        } else if (data.getHargaBeli() == null) {
            throwValidatorException("Harga beli barang tidak boleh null");
        } else if (data.getHargaBeli() <= 0) {
            throwValidatorException("Harga beli barang tidak valid");
        } else if (data.getHargaJual() == null) {
            throwValidatorException("Harga jual barang tidak boleh null");
        } else if (data.getHargaJual() <= 0) {
            throwValidatorException("Harga jual barang tidak valid");
        } else if (data.getHargaJual() < data.getHargaBeli()) {
            throwValidatorException("Harga jual barang tidak boleh lebih kecil dari harga beli");
        } else if (data.getStok() == null) {
            throwValidatorException("Stok barang tidak boleh null");
        }
    }
}
