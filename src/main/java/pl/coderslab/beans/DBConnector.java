package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class DBConnector {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "coderslab";

    public static Connection getConnection() throws SQLException {
        return getConnection(null);
    }

    public static Connection getConnection(String database) throws SQLException {

        String url = "jdbc:mysql://localhost:3306";

        if (database != null) {
            url += "/" + database;
        }

        Properties properties = new Properties();
        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("useSSL", "true");
        properties.setProperty("verifyServerCertificate", "false");
        properties.setProperty("useJDBCCompliantTimezoneShift", "true");
        properties.setProperty("useLegacyDatetimeCode", "false");
        properties.setProperty("serverTimezone", "UTC");
        properties.setProperty("characterEncoding", "utf8");

        return (Connection) DriverManager.getConnection(url, properties);
    }
}

