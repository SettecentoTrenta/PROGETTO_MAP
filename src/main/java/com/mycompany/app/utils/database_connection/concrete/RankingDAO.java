package com.mycompany.app.utils.database_connection.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mycompany.app.model.StatusModel;
import com.mycompany.app.utils.database_connection.abstracts.interfaces.Dao;

/**
 * Classe DAO per la tabella ranking.
 */
public class RankingDAO implements Dao<StatusModel> {

    /**
     * Istanza singleton.
     */
    private static RankingDAO instance;

    /**
     * Connessione al database.
     */
    private Connection connection;

    /**
     * Costruttore privato.
     */
    private RankingDAO() {

    }

    /**
     * Ottiene l'istanza singleton.
     * @return istanza singleton
     */
    public static RankingDAO getInstance() {
        if (instance == null) {
            instance = new RankingDAO();
        }
        return instance;
    }

    /**
     * Restituisce l'utente per id.
     */
    @Override
    public Optional<StatusModel> getByID(final int id) throws SQLException {
        StatusModel model = null;

        final String query = "SELECT * FROM ranking WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    model = StatusModel.getInstance();
                    model.setId(result.getInt("id"));
                    model.setPlayerName(
                        result.getString("player_name")
                    );
                    model.setTime(
                        result.getLong("total_time")
                    );
                }
            }
        }
        return Optional.ofNullable(model);
    }

    /**
     * Restituisce tutti gli utenti.
     */
    @Override
    public List<StatusModel> getAll() throws SQLException {
        List<StatusModel> models = new ArrayList<>();

        final String query = "SELECT * FROM ranking";

        try (Statement stmt = connection.createStatement()) {
            try (ResultSet resultSet = stmt.executeQuery(query)) {
                while (resultSet.next()) {
                    StatusModel model = StatusModel.getInstance();
                    model.setId(resultSet.getInt("id"));
                    model.setPlayerName(resultSet.getString("player_name"));
                    model.setTime(
                        resultSet.getLong("total_time")
                    );

                    models.add(model);
                }
            }
        }
        return models;
    }
}
