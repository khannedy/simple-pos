/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.service;

import com.stripbandunk.alexvariasi.entity.Pengaturan;

/**
 *
 * @author echo
 */
public interface PengaturanService {

    void save(Pengaturan pengaturan);

    void update(Pengaturan pengaturan);

    Pengaturan find(String kode);
}
