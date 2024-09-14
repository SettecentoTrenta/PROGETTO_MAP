package com.mycompany.app.utils.database_connection.abstracts.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    /**
     * Ottiene un oggetto dal database tramite id.
     * @param id id dell'oggetto
     * @return oggetto
     */
    Optional<T> getByID(int id) throws SQLException;

    /**
     * Ottiene tutti gli oggetti dal database.
     * @return lista di oggetti
     */
    List<T> getAll() throws SQLException;
}
