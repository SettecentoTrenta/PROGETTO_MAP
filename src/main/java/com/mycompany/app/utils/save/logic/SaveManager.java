package com.mycompany.app.utils.save.logic;

import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;

/**
 * Gestiosce il salvataggio.
 */
public final class SaveManager {

    /**
     * Costruttore privato.
     */
    public static void saveFile(final SaveGame game) {
        Gson gson = new Gson();
        String json = gson.toJson(game);

        try (FileWriter file = new FileWriter("src/main/java/com/mycompany/app/utils/save/gamedata/gamedata.json")) {
            file.write(json);
            System.out.println("File salvato con successo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Carica il file.
     * 
     * @return file
     */
    public static SaveGame loadFile() {
        Gson gson = new Gson();
        SaveGame game = null;

        try (FileReader reader = new FileReader("src/main/java/com/mycompany/app/utils/save/gamedata/gamedata.json")) {
            game = gson.fromJson(reader, SaveGame.class);
            System.out.println("File caricato con successo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }
}
