package com.mycompany.app.controller;

import java.io.Serializable;

import com.mycompany.app.model.GameObjModel;
import com.mycompany.app.model.Level;

/**
 * Gestore dei livelli.
 */
public class LevelController implements Serializable {

    /**
     * Matrice dei livelli (stanze adiacenti).
     */
    private Level[][] levels;

    /**
     * Coordinata X del livello corrente.
     */
    private static int currentLevelX = 0;

    /**
     * Coordinata Y del livello corrente.
     */
    private static int currentLevelY = 0;

    /**
     * Coordinata X del giocatore.
     */
    private static int playerX = 0;

    /**
     * Coordinata Y del giocatore.
     */
    private static int playerY = 0;

    /**
     * Costruttore del gestore di livelli.
     */
    public LevelController() {
        loadLevels();
    }

    /**
     * Restituisce il livello corrente.
     * @return il livello corrente
     */
    public Level getCurrentLevel() {
        return levels[currentLevelX][currentLevelY];
    }

    /**
     * Restituisce la coordinata X del livello corrente.
     * @return la coordinata X del livello corrente
     */
    public int getCurrentLevelX() {
        return currentLevelX;
    }

    /**
     * Restituisce la coordinata Y del livello corrente.
     * @return la coordinata Y del livello corrente
     */
    public int getCurrentLevelY() {
        return currentLevelY;
    }

    /**
     * Restituisce la coordinata X del livello corrente.
     * @return la coordinata X del livello corrente
     */
    public int getPlayerX() {
        return playerX;
    }

    /**
     * Restituisce la coordinata Y del livello corrente.
     * @return la coordinata Y del livello corrente
     */
    public int getPlayerY() {
        return playerY;
    }

    /**
     * Imposta la posizione del giocatore.
     * @param x coordinata X del giocatore
     * @param y coordinata Y del giocatore
     */
    public void setPlayerPosition(int x, int y) {
        playerX = x;
        playerY = y;
    }

    /**
     * Restituisce la matrice dei livelli.
     * @return la matrice dei livelli
     */
    public Level[][] getLevels() {
        return levels;
    }
      
    private void loadLevels() {
        int rows = 2;
        int cols = 2;
        levels = new Level[rows][cols];

        GameObjModel[][] map1 = {
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.IMPOSTOR, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.FAULT, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY}
        };
    
        GameObjModel[][] map2 = {
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.IMPOSTOR, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.FAULT, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY}
        };
    
        GameObjModel[][] map3 = {
            {GameObjModel.EMPTY, GameObjModel.FAULT, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.IMPOSTOR, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY}
        };
    
        GameObjModel[][] map4 = {
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.IMPOSTOR, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.FAULT, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY},
            {GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY, GameObjModel.EMPTY}
        };

        levels[0][0] = new Level("Level 0,0");
        levels[0][0].setMap(map1);

        levels[0][1] = new Level("Level 0,1");
        levels[0][1].setMap(map2);

        levels[1][0] = new Level("Level 1,0");
        levels[1][0].setMap(map3);

        levels[1][1] = new Level("Level 1,1");
        levels[1][1].setMap(map4);

        currentLevelX = 0;
        currentLevelY = 0;
        playerX = 0;
        playerY = 0;
    }
}