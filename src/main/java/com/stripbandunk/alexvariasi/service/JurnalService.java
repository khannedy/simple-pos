/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.service;

import com.stripbandunk.alexvariasi.entity.report.Jurnal;
import java.util.List;

/**
 *
 * @author echo
 */
public interface JurnalService {

    void save(Jurnal jurnal);

    List<Jurnal> findAll();
}
