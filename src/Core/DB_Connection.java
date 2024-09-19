package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    private static Connection connectionInstance;
    private DB_Connection(){}

    public static Connection getConnection() {
        String user = "root";
        String pass = "iLaRAsPEdRAN";
        String url = "jdbc:postgresql://localhost:5432/youcuisine";

        try {
            if (connectionInstance == null || connectionInstance.isClosed())
                connectionInstance = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Connection err: "+e);
        }
        return connectionInstance;
    }
}
