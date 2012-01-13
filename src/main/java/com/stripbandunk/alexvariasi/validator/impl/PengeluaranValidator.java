/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.validator.impl;

import com.stripbandunk.alexvariasi.entity.transaction.Pengeluaran;
import com.stripbandunk.alexvariasi.validator.AbstractValidator;
import com.stripbandunk.alexvariasi.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author echo
 */
@Component
public class PengeluaranValidator extends AbstractValidator<Pengeluaran> {

    @Override
    protected void doValidate(Pengeluaran data) throws ValidatorException {
        if (data.getNama() == null) {
            throwValidatorException("Nama pengeluaran tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {
            throwValidatorException("Nama pengeluaran tida boleh kosong");
        }
    }
}
