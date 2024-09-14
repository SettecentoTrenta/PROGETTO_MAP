package com.mycompany.app.utils.answerHandler;

import java.sql.SQLException;
import java.util.Random;

import javax.swing.JTextArea;

import com.mycompany.app.model.InventoryModel;
import com.mycompany.app.utils.api.JacksonMapper;
import com.mycompany.app.utils.commands.Commands;
import com.mycompany.app.utils.database_connection.concrete.InventoryDAO;
import com.mycompany.app.view.NewGameView;

/**
 * Gestisce le risposte.
 */
public class AnswerHandler {

    /**
     * Mapper Jackson.
     */
    private static JacksonMapper jm;
    
    /**
     * Nessuna risposta.
     * @return stringa vuota
     */
    public static String noAns() {
        return "";
    }

    private static void addInventory(final JTextArea textArea) {
        Random random = new Random();

        InventoryDAO inventory = InventoryDAO.getInstance();
        InventoryModel model = new InventoryModel();
        try {

            int id = random.nextInt(1, inventory.getAll().size());

            model.setId(id);
            model.setItemName(inventory.getByID(id).get().getItemName());
            model.setItemDescription(inventory.getByID(id).get().getItemDescription());
            
            textArea.append(model.getItemName() + "\n");
            InventoryModel.addToList(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Risposta positiva
     * @return esito
     */
    public static String onTrue() {
        jm = Commands.getJacksonMapper();
        System.out.println(jm.getResults().get(0).getCorrectAnswer());
        if (jm.getResults().get(0).getCorrectAnswer().equalsIgnoreCase("true")) {
            addInventory(NewGameView.getInventory());
            return "Risposta corretta";
        } else {
            return "Risposta sbagliata";
        }
    }

    /**
     * Risposta negativa.
     * @return esito
     */
    public static String onFalse() {
        jm = Commands.getJacksonMapper();
        System.out.println(jm.getResults().get(0).getCorrectAnswer());
        if (jm.getResults().get(0).getCorrectAnswer().equalsIgnoreCase("false")) {
            addInventory(NewGameView.getInventory());
            return "Risposta corretta";
        } else {
            return "Risposta sbagliata";
        }
    }
}
