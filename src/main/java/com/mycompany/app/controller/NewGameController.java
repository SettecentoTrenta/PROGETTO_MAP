package com.mycompany.app.controller;

import com.mycompany.app.view.StartView;

/**
 * Controller per la nuova partita.
 */
public final class NewGameController {

    /**
     * Costruttore della classe.
     */
    public NewGameController() {
    }

    public void openStartView() {
        StartView v = new StartView();
        v.setVisible(true);
        v.pack();
        v.setResizable(false);
    }
}
