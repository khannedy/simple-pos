/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stripbandunk.alexvariasi.view;

import javax.swing.JComponent;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public interface View {

    /**
     * fire on view is displaying
     * @param formApp
     */
    void display(FormApp formApp);

    /**
     * JComponent of this View
     * @return JComponent
     */
    JComponent getComponent();
}
