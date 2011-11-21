/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi;

import com.stripbandunk.alexvariasi.view.Form;
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

    private Form form;

    public App() {
        form = new Form();
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
            App app = new App();
            app.start();
        }
    }
}
