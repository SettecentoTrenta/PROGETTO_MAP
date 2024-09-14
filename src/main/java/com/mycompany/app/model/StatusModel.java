package com.mycompany.app.model;

import com.mycompany.app.utils.timemanager.TimeManager;

/**
 * Rappresenta informazioni quali il nome del giocatore <br/>
 * e il tempo trascorso nel gioco.
 */
public final class StatusModel {
    /**
     * Istanza.
     */
    private static StatusModel instance;

    /**
     * ID del giocatore.
     */
    private int player_id;

    /**
     * Nome giocatore.
     */
    private String playerName;

    /**
     * Costruttore privato.
     */
    private StatusModel() {

    }

    /**
     * Ottiene l'istanza singleton.
     * @return istanza singleton
     */
    public static StatusModel getInstance() {
        if (instance == null) {
            instance = new StatusModel();
        }
        return instance;
    }

    /**
     * Imposta l'ID del giocatore.
     * @param player_id ID del giocatore
     */
    public int getPlayer_id() {
        return player_id;
    }
    
    /**
     * Restituisce il nome del giocatore.
     * @return nome del giocatore
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Tempo trascorso.
     */
    private long elapsedTime;
    
    /**
     * Restituisce il tempo.
     * @return tempo
     */
    public String getTime() {
        return TimeManager.getTime();
    }

    /**
     * Imposta l'ID del giocatore.
     * @param idParam ID del giocatore
     */
    public void setId(final int idParam) {
        this.player_id = idParam;
    }

    /**
     * Imposta il nome del giocatore.
     * @param playerNameParam nome del giocatore
     */
    public void setPlayerName(final String playerNameParam) {
        this.playerName = playerNameParam;
    }

    /**
     * Imposta il tempo.
     * @param timeParam tempo
     */
    public void setTime(final long timeParam) {
        this.elapsedTime = timeParam;
    }
}
