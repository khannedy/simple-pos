/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.validator.impl;

import com.stripbandunk.alexvariasi.entity.user.Grup;
import com.stripbandunk.alexvariasi.validator.AbstractValidator;
import com.stripbandunk.alexvariasi.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Component
public class GrupValidator extends AbstractValidator<Grup> {
    
    public void doValidate(Grup data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Grup tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Kode grup tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Kode grup tidak boleh kosong");
        } else if (data.getNama() == null) {
            throwValidatorException("Nama grup tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama grup tidak boleh kosong");
        } else if (data.getDaftarHakAkses().isEmpty()) {
            throwValidatorException("Grup harus memiliki hak akses");
        }
    }
}
