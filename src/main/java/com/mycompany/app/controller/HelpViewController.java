package com.mycompany.app.controller;

import com.mycompany.app.view.HelpView;

/**
 * Help view controller.
 */
public class HelpViewController {

    /**
     * Constructor.
     */
    public HelpViewController() {
    }

    /**
     * Open help view.
     */
    public void openHelpView() {
        HelpView v = new HelpView();
        v.setVisible(true);
        v.pack();
        v.setResizable(false);
    }
}
