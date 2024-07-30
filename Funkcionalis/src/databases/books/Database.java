package databases.books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;

    private Database() {
    }

    private static Connection createConnection() {
        String url = "jdbc:postgresql://localhost/hetfo_szerda?user=postgres&password=admin";

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static Connection getConnection() {
        if (connection == null) {
            return createConnection();
        } else {
            return connection;
        }
    }

}
