package com.mycompany.app.viewmodel;

import com.mycompany.app.model.StatusModel;
import com.mycompany.app.utils.timemanager.TimeManager;

/**
 * ViewModel per lo status.
 */
public final class StatusViewModel {

    /**
     * Model dello status.
     */
    private StatusModel model;

    /**
     * Costruttore.
     * @param modelParam model dello status
     */
    public StatusViewModel(final StatusModel modelParam) {
        this.model = modelParam;
    }

    /**
     * Imposta l'ID del giocatore.
     * @param player_id ID del giocatore
     */
    public int getPlayer_id() {
        return model.getPlayer_id();
    }

    /**
     * Restituisce il nome del giocatore.
     * @return nome del giocatore
     */
    public String getPlayerName() {
        return model.getPlayerName();
    }

    /**
     * Restituisce il tempo trascorso.
     * @return tempo trascorso
     */

    /* Disabilitato perché manca la classe getElapsedTime su model
    public long getElapsedTime() {
        return model.getElapsedTime();
    };
     */
    
    /**
     * Imposta l'ID del giocatore.
     * @param idParam ID del giocatore
     */
    public void setId(final int idParam) {
        model.setId(idParam);
    }

    /**
     * Imposta il nome del giocatore.
     * @param playerNameParam nome del giocatore
     */
    public void setPlayerName(final String playerNameParam) {
        model.setPlayerName(playerNameParam);
    }

    /**
     * Imposta il tempo.
     * @param timeParam tempo
     */
    public void setTime(final long timeParam) {
        model.setTime(timeParam);
    }
}
