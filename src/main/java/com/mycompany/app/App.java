package com.mycompany.app;

import java.io.IOException;
import java.sql.SQLException;

import com.mycompany.app.utils.database_connection.concrete.DatabaseConnection;
import com.mycompany.app.view.StartView;

/**
 * Entry point.
 */
public final class App {

    /**
     * Connessione al database.
     */
    private static DatabaseConnection db;

    /**
     * Entry point.
     * @param args argomenti funzione main
     */
    public static void main(final String[] args) {
        try  {
            db = DatabaseConnection.getInstance();
            db.connect();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        StartView v = new StartView();
        v.setVisible(true);
        v.pack();
        v.setResizable(false);
    }

    @Override
    public void finalize() {
        try {
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
