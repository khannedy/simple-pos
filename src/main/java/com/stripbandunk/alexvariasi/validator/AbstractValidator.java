/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.validator;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public abstract class AbstractValidator<T> implements Validator<T> {

    public void throwValidatorException(String message) throws ValidatorException {
        throw new ValidatorException(message);
    }
}
