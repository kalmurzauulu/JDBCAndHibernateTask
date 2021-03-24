package peaksoft;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        userDaoJdbc.dropUsersTable();
        userDaoJdbc.createUsersTable();
        userDaoJdbc.saveUser("DDDDssf","dasda", (byte) 85);
        userDaoJdbc.getAllUsers();
        userDaoJdbc.removeUserById(2);
        userDaoJdbc.cleanUsersTable();
    }
}
