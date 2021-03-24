package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

public class Util {
    // реализуйте настройку соеденения с БД

        private  static final String url = "jdbc:postgresql://localhost:5432/postgres";
        private  static final String login = "postgres";
        private  static final String password = "Jashtykketty";

        public static Connection connection() {
                Connection connect = null;
                try {
                        connect = DriverManager.getConnection(url, login, password);
                        System.out.println("Connected to the table sucsessfully");

                } catch (SQLException e) {
                        e.getMessage();

                }
        return connect;
        }
}
