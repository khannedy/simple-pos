/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.manager;

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

    private LoginManager() {
        // singleton class
    }

    public boolean login(String username, String password) {
        return false;
    }

    public void logout() {
        
    }
}
