/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.manager;

import com.stripbandunk.alexvariasi.entity.master.Jabatan;
import com.stripbandunk.alexvariasi.entity.master.Karyawan;
import com.stripbandunk.alexvariasi.entity.user.Grup;
import com.stripbandunk.alexvariasi.entity.user.HakAkses;
import com.stripbandunk.alexvariasi.entity.user.HakAksesConstant;
import com.stripbandunk.alexvariasi.entity.user.Pengguna;
import com.stripbandunk.alexvariasi.service.*;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class SpringManager {

    private ApplicationContext applicationContext;

    private SpringManager() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.registerShutdownHook();

        this.applicationContext = context;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(requiredType);
    }

    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }

    private static SpringManager INSTANCE;

    public static SpringManager getInstance() {
        if (SpringManager.INSTANCE == null) {
            SpringManager.INSTANCE = new SpringManager();

            HakAksesService hakAksesService = SpringManager.getInstance().getBean(HakAksesService.class);
            for (HakAksesConstant constant : HakAksesConstant.values()) {
                HakAkses hakAkses = hakAksesService.find(constant.toString());
                if (hakAkses == null) {
                    hakAkses = new HakAkses();
                    hakAkses.setId(constant.toString());
                    hakAkses.setNama(constant.toString());
                    hakAkses.setWaktuDibuat(new Date());
                    hakAkses.setTerakhirDirubah(new Date());
                    hakAksesService.save(hakAkses);
                }
            }

            GrupService grupService = SpringManager.getInstance().getBean(GrupService.class);
            Grup grup = grupService.find("ADMIN");
            if (grup == null) {
                grup = new Grup();
                grup.setId("ADMIN");
                grup.setNama("Administrator");
                List<HakAkses> akseses = hakAksesService.findAll();
                for (HakAkses akses : akseses) {
                    grup.tambahHakAkses(akses);
                }
                grup.setTerakhirDirubah(new Date());
                grup.setWaktuDibuat(new Date());
                grupService.save(grup);
            }

            JabatanService jabatanService = SpringManager.getInstance().getBean(JabatanService.class);
            Jabatan jabatan = jabatanService.find("admin");
            if (jabatan == null) {
                jabatan = new Jabatan();
                jabatan.setId("admin");
                jabatan.setNama("Administrator");
                jabatan.setTerakhirDirubah(new Date());
                jabatan.setWaktuDibuat(new Date());
                jabatanService.save(jabatan);
            }

            KaryawanService karyawanService = SpringManager.getInstance().getBean(KaryawanService.class);
            Karyawan karyawan = karyawanService.find("admin");
            if (karyawan == null) {
                karyawan = new Karyawan();
                karyawan.setId("admin");
                karyawan.setJabatan(jabatan);
                karyawan.setKota("Bandung");
                karyawan.setNama("Administrator");
                karyawan.setTanggalLahir(new Date());
                karyawan.setTanggalMasuk(new Date());
                karyawan.setTelepon("085000000000");
                karyawan.setTerakhirDirubah(new Date());
                karyawan.setWaktuDibuat(new Date());
                karyawanService.save(karyawan);
            }

            PenggunaService penggunaService = SpringManager.getInstance().getBean(PenggunaService.class);
            Pengguna pengguna = penggunaService.find("admin");
            if (pengguna == null) {
                pengguna = new Pengguna();
                pengguna.setAktif(true);
                pengguna.setGrup(grup);
                pengguna.setId("admin");
                pengguna.setKaryawan(karyawan);
                pengguna.setKataSandi("admin");
                pengguna.setTerakhirDirubah(new Date());
                pengguna.setWaktuDibuat(new Date());
                penggunaService.save(pengguna);
            }

        }
        return SpringManager.INSTANCE;
    }
}
