package com.mycompany.app.utils.database_connection.concrete;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mycompany.app.model.InventoryModel;
import com.mycompany.app.utils.database_connection.abstracts.interfaces.Dao;

public final class InventoryDAO implements Dao<InventoryModel> {

    /**
     * Istanza singleton.
     */
    private static InventoryDAO instance;

    /**
     * Connessione al database.
     */
    private Connection connection;

    /**
     * Ottiene l'istanza singleton.
     * @return istanza singleton
     */
    public static InventoryDAO getInstance() {
        if (instance == null) {
            instance = new InventoryDAO(
                DatabaseConnection.getInstance().getConnection()
            );
        }
        return instance;
    }

    /**
     * Costruttore privato.
     * @param connectionParam connessione al database
     */
    private InventoryDAO(final Connection connectionParam) {
        this.connection = connectionParam;
    }

    /**
     * Ottiene un oggetto dal database tramite id.
     * @param id id dell'oggetto
     */
    @Override
    public Optional<InventoryModel> getByID(final int id) throws SQLException {
        InventoryModel model = null;

        final String query = "SELECT * FROM inventory WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    model = new InventoryModel();
                    model.setId(result.getInt("id"));
                    model.setItemName(
                        result.getString("item_name")
                    );
                    model.setItemDescription(
                        result.getString("item_description")
                    );
                }
            }
        }
        return Optional.ofNullable(model);
    }


    /**
     * Ottiene tutti gli oggetti dal database.
     * @return lista di oggetti
     */
    public List<InventoryModel> getAll() throws SQLException {
        List<InventoryModel> models = new ArrayList<>();

        final String query = "SELECT * FROM inventory";

        try (Statement stmt = connection.createStatement()) {
            try (ResultSet resultSet = stmt.executeQuery(query)) {
                while (resultSet.next()) {
                    InventoryModel model = new InventoryModel();
                    model.setId(resultSet.getInt("id"));
                    model.setItemName(resultSet.getString("item_name"));
                    model.setItemDescription(
                        resultSet.getString("item_description")
                    );

                    models.add(model);
                }
            }
        }
        return models;
    }
}
