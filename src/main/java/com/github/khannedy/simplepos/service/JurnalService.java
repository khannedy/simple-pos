/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.khannedy.simplepos.service;

import com.github.khannedy.simplepos.entity.report.Jurnal;
import java.util.List;

/**
 *
 * @author echo
 */
public interface JurnalService {

    void save(Jurnal jurnal);

    List<Jurnal> findAll();
}
