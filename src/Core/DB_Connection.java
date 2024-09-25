package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    private static final String user = "root";
    private static final String pass = "iLaRAsPEdRAN";
    private static final String url = "jdbc:postgresql://localhost:5432/youcuisine";

    private DB_Connection(){}

    private static class connectionHelper {
        private static final Connection INSTANCE;

        static {
            try {
                Class.forName("org.postgresql.Driver");
                INSTANCE = DriverManager.getConnection(url, user, pass);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Connection getConnection() {
        return connectionHelper.INSTANCE;
    }
}
