/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.manager;

import com.stripbandunk.alexvariasi.entity.user.Pengguna;
import com.stripbandunk.alexvariasi.service.PenggunaService;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class LoginManager {

    private static LoginManager INSTANCE;

    public static LoginManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginManager();
        }
        return LoginManager.INSTANCE;
    }

    private String id;

    private LoginManager() {
        // singleton class
    }

    public boolean login(String username, String password) {
        if (getPenggunaService().contains(username, password)) {
            this.id = username;
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        this.id = null;
    }

    public Pengguna getPengguna() {
        if (id == null) {
            return null;
        } else {
            return getPenggunaService().find(id);
        }
    }

    private PenggunaService getPenggunaService() {
        return SpringManager.getInstance().getBean(PenggunaService.class);
    }
}
