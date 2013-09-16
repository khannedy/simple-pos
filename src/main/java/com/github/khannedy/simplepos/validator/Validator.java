/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.validator;

/**
 *
 * @param <T> data
 * @author Eko Kurniawan Khannedy
 */
public interface Validator<T> {

    void validate(T data) throws ValidatorException;
}
