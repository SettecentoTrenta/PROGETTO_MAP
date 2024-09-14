package com.mycompany.app.utils.commands;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.controller.LevelController;
import com.mycompany.app.model.GameObjModel;
import com.mycompany.app.utils.api.ApiRequest;
import com.mycompany.app.utils.api.JacksonMapper;
import com.mycompany.app.utils.constants.EnumDirections;
import com.mycompany.app.model.Level;

/**
 * Contiene le funzioni associate ai comandi.
 */
public final class Commands {

    /**
     * Gestore dei livelli.
     */
    private static LevelController lvlController;

    /**
     * Posizione livello x.
     */
    private static int currentLevelX = 0;

    /**
     * Posizione livello y.
     */
    private static int currentLevelY = 0;

    /**
     * Mappa del livello corrente.
     */
    private static GameObjModel[][] map = null;


    /**
     * Matrice dei livelli.
     */
    private static Level[][] levels = null;

    /**
     * Mapper Jackson.
     */
    private static JacksonMapper jm;

    /**
     * Costruttore classe.
     */
    private Commands() {
    }

    public static void loadController(final LevelController levelController) {

        Commands.lvlController = levelController;

        currentLevelX = lvlController.getCurrentLevelX();
        currentLevelY = lvlController.getCurrentLevelY();
        levels = lvlController.getLevels();
        map = levels[currentLevelY][currentLevelX].getMap();
        printMap(map);
    }


    /**
     * Setta il gestore dei livelli.
     */
    public static void setLvlController(final LevelController levelController) {
        Commands.lvlController = levelController;

        currentLevelX = lvlController.getCurrentLevelX();
        currentLevelY = lvlController.getCurrentLevelY();
        levels = lvlController.getLevels();
        map = levels[currentLevelY][currentLevelX].getMap();
        printMap(map);
    }

    /**
     * Visualizza tutti i comandi disponibili.
     * @return stringa contenente tutti i comandi disponibili
     */
    public static String helpCommand() {
        return Stream.of(EnumCommands.values())
              .skip(1L)
              .map(command -> command.getCommandInfo())
              .collect(Collectors.joining("\n"));
    }

    /**
     * Mostra all'utente che il comando da lui scelto non è valido.
     */
    protected static String noAction() {
        return "Comando non valido";
    }

    /**
     * Cambia il livello (stanza) corrente in base alla direzione.
     * @param direction la direzione verso cui cambiare stanza
     * @return true se il cambio di stanza è avvenuto, false se non è possibile
     */
    public static boolean changeLevel(EnumDirections direction) {

        switch (direction) {
            case NORD -> {
                if (currentLevelY > 0) {
                    currentLevelY--;
                    System.out.println("Cambio stanza a nord");
                    map = levels[currentLevelY][currentLevelX].getMap();
                    printMap(map);
                    return true;
                }
            }
            case SUD -> {
                if (currentLevelY < levels[0].length - 1) {
                    currentLevelY++;
                    System.out.println("Cambio stanza a sud");
                    map = levels[currentLevelY][currentLevelX].getMap();
                    printMap(map);
                    return true;
                }
            }
            case EST -> {
                if (currentLevelX < levels.length - 1) {
                    currentLevelX++;
                    System.out.println("Cambio stanza a est");
                    map = levels[currentLevelY][currentLevelX].getMap();
                    printMap(map);
                    return true;
                }
            }
            case OVEST -> {
                if (currentLevelX > 0) {
                    currentLevelX--;
                    System.out.println("Cambio stanza a ovest");
                    map = levels[currentLevelY][currentLevelX].getMap();
                    printMap(map);
                    return true;
                }
            }
            default -> {
                break;
            }
        }
        return false;
    }

    /**
     * Sposta il giocatore.
     * @param directionString direzione in cui spostare il giocatore
     */
    public static String movePlayer(final EnumDirections directions) {

        int playerX = lvlController.getPlayerX();
        int playerY = lvlController.getPlayerY();

        switch (directions) {
            case NORD -> {
                if (currentLevelY == 0 && playerY == 0) { 
                    return "Non puoi andare più a nord!";
                } else if (playerY == 0) { 
                    if (changeLevel(EnumDirections.NORD)) {
            
                        setPlayerPosition(playerX, map.length - 1);
                    } else {
                        return "Non puoi andare più a nord!";
                    }
                } else {
                    setPlayerPosition(playerX, playerY - 1);
                }
            }
            case SUD -> {
                if (playerY == map.length - 1) { 
                    if (changeLevel(EnumDirections.SUD)) {
            
                        setPlayerPosition(playerX, 0);
                    } else {
                        return "Non puoi andare più a sud!";
                    }
                } else {
                    setPlayerPosition(playerX, playerY + 1);
                }
            }
            case EST -> {
                if (playerX == map[0].length - 1) { 
                    if (changeLevel(EnumDirections.EST)) {
            
                        setPlayerPosition(0, playerY);
                    } else {
                        return "Non puoi andare più a est!";
                    }
                } else {
                    setPlayerPosition(playerX + 1, playerY);
                }
            }
            case OVEST -> {
                if (playerX == 0) { 
                    if (changeLevel(EnumDirections.OVEST)) {
            
                        setPlayerPosition(map[0].length - 1, playerY);
                    } else {
                        return "Non puoi andare più a ovest!";
                    }
                } else {
                    setPlayerPosition(playerX - 1, playerY);
                }
            }
            default -> {
                return "Direzione non valida!";
            }
        }

        GameObjModel currentCell = map[getPlayerY()][getPlayerX()];
        switch (currentCell) {
            case IMPOSTOR -> {
                System.out.println("Attenzione: hai trovato l'impostore!");
                System.exit(0);
            }
            case FAULT -> {
                jm = null;
                System.out.println("Attenzione: hai trovato un guasto!");
                System.out.println("Carico la domanda...");
                return getJacksonMapper().getResults().get(0).getQuestion();
            }
            default -> {
                break;
            }
        }
        return "Giocatore spostato a " + getPlayerX() + ", " + getPlayerY();
    }

    /**
     * Converte la mappa in una stringa e la stampa sul terminale.
     */
    private static void printMap(GameObjModel[][] map) {
        System.out.printf("Mappa: %s\n", levels[currentLevelY][currentLevelX].getName());
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                switch (map[y][x]) {
                    case EMPTY -> System.out.print("E ");
                    case IMPOSTOR -> System.out.print("I ");
                    case FAULT -> System.out.print("F ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int getPlayerX() {
        return lvlController.getPlayerX();
    }

    private static int getPlayerY() {
        return lvlController.getPlayerY();
    }

    private static void setPlayerPosition(int x, int y) {
        lvlController.setPlayerPosition(x, y);
    }

    public static JacksonMapper getJacksonMapper() {
        if (jm == null) {
            initJacksonMapper();
        }
        return jm;
    }

    private static void initJacksonMapper() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            jm = mapper.readValue(new ApiRequest().fetch(), JacksonMapper.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
