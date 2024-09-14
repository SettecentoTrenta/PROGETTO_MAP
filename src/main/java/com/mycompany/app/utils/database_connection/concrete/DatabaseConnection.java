package com.mycompany.app.utils.database_connection.concrete;

import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Connessione al database.
 */
public final class DatabaseConnection {

    /**
     * Istanza singleton.
     */
    private static DatabaseConnection instance;

    /**
     * Path del file delle proprietà.
     */
    private static final Path PROPERTIES_PATH = Path.of(
        "./src/main/java/com/mycompany/app/utils/database/"
        + "database.properties"
    );

    /**
     * Proprietà del database.
     */
    private static Properties properties;

    /**
     * Connessione al database.
     */
    private Connection connection;

    /**
     * URL del database.
     */
    private String url;

    /**
     * Username del database.
     */
    private String username;

    /**
     * Password del database.
     */
    private String password;

    /*
     * Carica i driver del database.
     */
    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Costruttore privato.
     */
    private DatabaseConnection() {

    }

    /**
     * Ottiene l'istanza singleton.
     * @return istanza singleton
     */
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    /**
     * Inizializa le proprietà del database.
     * @param propertiesPathParam path del file delle proprietà
     */
    private void initProperties(final Path propertiesPathParam)
    throws IOException {
        properties = new Properties();

        properties.load(new FileInputStream(PROPERTIES_PATH.toFile()));
    }

    /**
     * Carica le proprietà del database.
     */
    private void loadProperties() throws IOException {
        initProperties(PROPERTIES_PATH);

        this.url = properties.getProperty("database.url");
        this.username = properties.getProperty("database.username");
        this.password = properties.getProperty("database.password");
    }

    /**
     * Inizializza la connessione al database.
     */
    private void initConnection() throws SQLException {
        this.connection = DriverManager.getConnection(
            url,
            username,
            password
        );
    }

    /**
     * Esegue lo script del database.
     */
    private void runSchemaScript() throws SQLException {
        final String scriptPath = properties.getProperty(
            "database.runSchemaScript"
        );

        Statement stmt = connection.createStatement();
        stmt.executeUpdate(scriptPath);
    }

    /**
     * Esegue lo script per la creazione dell'inventario.
     */
    private void runInventoryScript() throws SQLException {
        final String scriptPath = properties.getProperty(
            "database.runInventoryScript"
        );

        Statement stmt = connection.createStatement();
        stmt.executeUpdate(scriptPath);
    }

    /**
     * Connessione al database.
     */
    public void connect() throws SQLException, IOException {
        loadProperties();
        initConnection();
        runSchemaScript();
        runInventoryScript();
    }

    /**
     * Ritorna la connessione al database.
     * @return connessione al database
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Chiude la connessione al database.
     */
    public void close() throws SQLException {
        connection.close();
    }
}
