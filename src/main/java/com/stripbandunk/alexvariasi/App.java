/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi;

import com.stripbandunk.alexvariasi.entity.user.HakAkses;
import com.stripbandunk.alexvariasi.manager.SpringManager;
import com.stripbandunk.alexvariasi.service.HakAksesService;
import java.util.Date;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HakAksesService service = SpringManager.getInstance().getBean(HakAksesService.class);

        HakAkses hakAkses = new HakAkses();
        hakAkses.setId("login");
        hakAkses.setNama("Login sebagai pengguna");
        hakAkses.setWaktuDibuat(new Date());
        hakAkses.setTerakhirDirubah(new Date());

        service.save(hakAkses);
    }
}
