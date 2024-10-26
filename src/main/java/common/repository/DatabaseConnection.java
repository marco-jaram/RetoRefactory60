package common.repository;



import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;


@Slf4j
public class DatabaseConnection {
    private static final String URL = "jdbc:h2:mem:bookstoredb;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:db/schema.sql'\\;RUNSCRIPT FROM 'classpath:db/data.sql'";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static DatabaseConnection instance;
    private final Connection connection;

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(true);
            initDatabase();
            log.info("Database connection established successfully");
        } catch (SQLException e) {
            log.error("Error connecting to database", e);
            throw new RuntimeException("Cannot connect to database", e);
        }
    }

    private void initDatabase() {
        try {
            // Ejecutar schema.sql
            executeScript("db/schema.sql");
            // Ejecutar data.sql
            executeScript("db/data.sql");
            log.info("Database initialized successfully");
        } catch (Exception e) {
            log.error("Error initializing database", e);
            throw new RuntimeException("Cannot initialize database", e);
        }
    }

    private void executeScript(String resourcePath) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(resourcePath)))) {

            String script = reader.lines().collect(Collectors.joining("\n"));
            try (Statement stmt = connection.createStatement()) {
                stmt.execute(script);
            }
        } catch (Exception e) {
            log.error("Error executing script: " + resourcePath, e);
            throw new RuntimeException("Error executing database script", e);
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}