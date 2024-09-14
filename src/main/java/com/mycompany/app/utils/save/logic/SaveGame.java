package com.mycompany.app.utils.save.logic;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mycompany.app.controller.LevelController;
import com.mycompany.app.model.InventoryModel;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public final class SaveGame implements Serializable {

    /**
     * Inventario del giocatore.
     */
    private List<InventoryModel> inventory;

    /**
     * Controller del livello.
     */
    private LevelController levelController;

    /**
     * Coordinata X del giocatore.
     */
    private int playerX;

    /**
     * Coordinata Y del giocatore.
     */
    private int playerY;

    /**
     * Costruttore.
     * 
     * @param inventory inventario
     * @param levelController controller del livello
     */
    @JsonCreator
    public SaveGame(@JsonProperty("inventory") List<InventoryModel> inventory,
                    @JsonProperty("levelController") LevelController levelController) {
        this.inventory = inventory;
        this.levelController = levelController;
    }

    /**
     * Restituisce l'inventario.
     * 
     * @return inventario
     */
    public List<InventoryModel> getInventory() {
        return inventory;
    }

    /**
     * Restituisce il controller del livello.
     * 
     * @return controller del livello
     */
    public LevelController getLevelController() {
        return levelController;
    }

    /**
     * Restituisce la coordinata X del giocatore.
     * 
     * @return coordinata X del giocatore
     */
    public int getPlayerX() {
        return playerX;
    }

    /**
     * Restituisce la coordinata Y del giocatore.
     * 
     * @return coordinata Y del giocatore
     */
    public int getPlayerY() {
        return playerY;
    }

    /**
     * Imposta la coordinata X del giocatore.
     * 
     * @param playerX coordinata X del giocatore
     */
    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    /**
     * Imposta la coordinata Y del giocatore.
     * 
     * @param playerY coordinata Y del giocatore
     */
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }
}