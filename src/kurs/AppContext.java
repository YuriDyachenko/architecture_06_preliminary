package kurs;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AppContext {
    private static final AppContext instance = new AppContext();
    private Properties dbProperties;
    private Connection connection;
    private IdentityMap identityMap;

    private AppContext() {
        dbProperties = new Properties();
        try {
            InputStream in = Files.newInputStream(Paths.get("db.properties"));
            dbProperties.load(in);
        } catch (IOException e) {
            dbProperties = null;
        }
        connection = null;
        identityMap = null;
    }

    public static AppContext getInstance() {
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            if (dbPropertiesIsLoaded()) {
                try {
                    connection = DriverManager.getConnection(getDbProperty("url"),
                            getDbProperty("username"),
                            getDbProperty("password"));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection == null) return;
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean dbPropertiesIsLoaded() {
        return (dbProperties != null);
    }

    public String getDbProperty(String name) {
        if (!dbPropertiesIsLoaded()) return null;
        return dbProperties.getProperty(name, "");
    }

    public IdentityMap getIdentityMap() {
        if (identityMap == null) identityMap = new IdentityMap();
        return identityMap;
    }
}
