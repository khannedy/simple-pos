/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.validator.impl;

import com.stripbandunk.alexvariasi.entity.transaction.Pemasukkan;
import com.stripbandunk.alexvariasi.validator.AbstractValidator;
import com.stripbandunk.alexvariasi.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author echo
 */
@Component
public class PemasukkanValidator extends AbstractValidator<Pemasukkan> {

    @Override
    protected void doValidate(Pemasukkan data) throws ValidatorException {
        if (data.getNama() == null) {
            throwValidatorException("Nama pemasukkan tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama pemasukkan tida boleh kosong");
        }
    }
}
