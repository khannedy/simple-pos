/*
 * Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.khannedy.simplepos.view;

import com.stripbandunk.jglasspane.JGlassPane;
import com.stripbandunk.jglasspane.component.MessageComponent;
import javax.swing.JDialog;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public abstract class DialogView extends JDialog implements View {

    private JGlassPane jGlassPane;

    private MessageComponent messageComponent;

    private FormApp formApp;

    public DialogView(FormApp formApp) {
        super(formApp, true);
        initGlassPanes();
    }

    public FormApp getFormApp() {
        return formApp;
    }

    private void initGlassPanes() {
        jGlassPane = new JGlassPane();

        messageComponent = new MessageComponent();
        jGlassPane.addGlassPaneComponent(messageComponent);

        setGlassPane(jGlassPane);
        getGlassPane().setVisible(true);
    }

    public void showWarning(String message) {
        messageComponent.showWarning(message);
    }

    public void showError(String message) {
        messageComponent.showError(message);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }
}
