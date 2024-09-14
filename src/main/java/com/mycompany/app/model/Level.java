package com.mycompany.app.model;

import java.io.Serializable;

/**
 * Level class.
 */
public final class Level implements Serializable {
    /**
     * Level name.
     */
    private String name;

    /**
     * Level map.
     */
    private GameObjModel[][] map;


    /**
     * Level constructor.
     */
    public Level(final String name) {
        this.name = name;
    }

    /**
     * Get level name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set level map.
     * @param mapParam map
     */
    public void setMap(final GameObjModel[][] mapParam) {
        this.map = mapParam;
    }

    /**
     * Get level name.
     * @param nameParam name
     */
    public GameObjModel[][] getMap() {
        return this.map;
    }
}
