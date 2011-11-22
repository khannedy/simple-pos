/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi;

import com.stripbandunk.alexvariasi.manager.SpringManager;
import com.stripbandunk.alexvariasi.view.FormApp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class App implements Runnable {

    private FormApp form;

    public App() {
        form = new FormApp();
    }

    public void start() {
        SwingUtilities.invokeLater(this);
    }

    public void run() {
        form.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // ini spring
            SpringManager.getInstance();

            // run app
            App app = new App();
            app.start();
        }
    }
}
