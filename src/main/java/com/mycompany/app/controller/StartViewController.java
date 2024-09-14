package com.mycompany.app.controller;

import javax.swing.JFrame;

import com.mycompany.app.utils.save.logic.SaveGame;
import com.mycompany.app.utils.save.logic.SaveManager;
import com.mycompany.app.view.NewGameView;

/**
 * Controller della vista di avvio.
 */
public final class StartViewController {

    /**
     * Costruttore della classe.
     */
    public StartViewController() {
    }

    /**
     * inizializza la view di avvio.
     */
    public void openNewGameView(JFrame mainFrame) {
        NewGameView panel = new NewGameView();
        mainFrame.setContentPane(panel); 
        mainFrame.revalidate(); 
        mainFrame.repaint();
    }

    public void loadGame(JFrame mainFrame) {
        SaveGame game = SaveManager.loadFile();

        NewGameView panel = new NewGameView(game);
        mainFrame.setContentPane(panel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
