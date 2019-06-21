package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {

    public static Connection newConnection(String host, String port, String dbName, String type,
                                           String user, String password) {

        DriverLoader.loadDriver();

        String url = "jdbc:" + type + "://" + host + ":" + port + "/" + dbName + "?user=" +
                user + "&password=" + password;

        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

}
