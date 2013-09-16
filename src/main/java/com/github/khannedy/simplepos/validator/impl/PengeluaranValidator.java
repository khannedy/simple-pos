/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.khannedy.simplepos.validator.impl;

import com.github.khannedy.simplepos.entity.transaction.Pengeluaran;
import com.github.khannedy.simplepos.validator.AbstractValidator;
import com.github.khannedy.simplepos.validator.ValidatorException;
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
