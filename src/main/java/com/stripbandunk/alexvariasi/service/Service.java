/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.service;

import com.stripbandunk.alexvariasi.entity.AbstractEntity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @param <T> entity
 * @param <ID> id
 * @author Eko Kurniawan Khannedy
 */
public interface Service<T extends AbstractEntity<?>, ID extends Serializable> {

    void save(T entity);

    void update(T entity);

    void remove(T entity);

    T find(ID id);

    List<T> findAll();
}
