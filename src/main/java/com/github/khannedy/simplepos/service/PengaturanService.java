/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.khannedy.simplepos.service;

import com.github.khannedy.simplepos.entity.Pengaturan;

/**
 *
 * @author echo
 */
public interface PengaturanService {

    void save(Pengaturan pengaturan);

    void update(Pengaturan pengaturan);

    Pengaturan find(String kode);
}
