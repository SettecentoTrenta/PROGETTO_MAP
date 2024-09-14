package com.mycompany.app.utils.commands;

import java.util.function.Supplier;
import java.util.stream.Stream;

import com.mycompany.app.utils.constants.EnumDirections;


/**
 * Contiene i comandi.
 */
public enum EnumCommands {

    /**
     * Comando invalido.
     */
    INVALID(
        "",
        "Comando non valido",
        () -> Commands.noAction()
    ),

    /**
     * Comando HELP.
     * Mostra tutti i comandi disponibili
     */
    HELP(
        "help",
        "mostra la lista dei comandi disponibili",
        () -> Commands.helpCommand()
    ),

    /**
     * Comando NORD.
     * Sposta il giocatore a nord.
     */
    NORD(
        "nord",
        "Sposta il giocatore a nord",
        () -> Commands.movePlayer(EnumDirections.NORD)
    ),

    /**
     * Comando SUD.
     * Sposta il giocatore a sud.
     */
    SUD(
        "sud",
        "Sposta il giocatore a sud",
        () -> Commands.movePlayer(EnumDirections.SUD)
    ),

    /**
     * Comando EST.
     * Sposta il giocatore a est.
     */
    EST(
        "est",
        "Sposta il giocatore a est",
        () -> Commands.movePlayer(EnumDirections.EST)
    ),

    /**
     * Comando OVEST.
     * Sposta il giocatore a ovest.
     */
    OVEST(
        "ovest",
        "Sposta il giocatore a ovest",
        () -> Commands.movePlayer(EnumDirections.OVEST)
    );

    /**
     * Comando inserito in input dall'utente.
     */
    private final String command;

    /**
     * Descrizione del comando.
     */
    private final String description;

    /**
     * Metodo da eseguire.
     */
    private final Supplier<String> action;

    /**
     * Costruttore della enum.
     * @param commandParam comando
     * @param descriptionParam descrizione comando
     * @param actionParam metodo da eseguire
     */
    EnumCommands(
        final String commandParam,
        final String descriptionParam,
        final Supplier<String> actionParam
    ) {
        this.command = commandParam;
        this.description = descriptionParam;
        this.action = actionParam;
    }

    /**
     * Ritorna il comando.
     * @return comando
     */
    public String getCommand() {
        return command;
    }

    /**
     * Ritorna la descrizione del comando.
     * @return descrizione del comando
     */
    public String getDescription() {
        return description;
    }

    /**
     * Ritorna il comando e la descrizione.
     * @return comando e descrizione
     */
    public String getCommandInfo() {
        return new StringBuilder(command)
                   .append(" - ")
                   .append(description)
                   .append("\n")
                   .toString();
    }

    /**
     * Ritorna il metodo associato al comando.
     * @return action
     */
    public Supplier<String> getAction() {
        return action;
    }

    /**
     * Esegue il metodo inserito nella enum.
     */
    public String execute() {
        return action.get();
    }

    /**
     * Da una stringa in input, restituisce il comando.
     * @param command comando
     * @return il comando, sottoforma di EnumCommands
     */
    public static EnumCommands fromString(final String command) {
        return Stream.of(EnumCommands.values())
                     .filter(c -> c.getCommand().equalsIgnoreCase(command))
                     .findFirst()
                     .orElse(INVALID);
    }
}
