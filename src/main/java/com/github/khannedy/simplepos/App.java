/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos;

import com.github.khannedy.simplepos.manager.SpringManager;
import com.github.khannedy.simplepos.view.FormApp;
import com.github.khannedy.simplepos.view.impl.LoginView;
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

    @Override
    public void run() {
        form.setVisible(true);
        LoginView view = new LoginView(form);
        view.display(form, null);
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
