package com.mycompany.app.model;
/**
 * GameObjModel enum.
 */
public enum GameObjModel {
    /**
     * Impostor.
     */
    IMPOSTOR('I'),

    /**
     * Fault.
     */
    FAULT('F'),
    
    /**
     * Empty.
     */
    EMPTY(' ');

    /**
     * Value.
     */
    @SuppressWarnings("unused")
    private char value;

    /**
     * Constructor.
     * @param valueParam value
     */
    GameObjModel(final char valueParam) {
        this.value = valueParam;
    }
}
