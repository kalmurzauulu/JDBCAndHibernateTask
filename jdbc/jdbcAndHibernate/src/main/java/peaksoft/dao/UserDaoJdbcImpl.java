package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static peaksoft.util.Util.connection;


public class UserDaoJdbcImpl implements UserDao {
    User user = new User();
    Util util = new Util();


    public UserDaoJdbcImpl() {


    }


    public void createUsersTable() throws SQLException {
        Connection connect = util.connection();
        Statement statement = connect.createStatement();
        String SQL = "CREATE TABLE IF NOT EXISTS users" +
                "(id  SERIAL NOT NULL," +
                "name VARCHAR (50)," +
                "last_name VARCHAR(50)," +
                "age INTEGER)";
        statement.executeUpdate(SQL);
        System.out.println("Table succsessfully created");
    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE users";
        try {
            Connection connection = util.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "insert into users (name,last_name,age) values (?,?,?);";
            try (Connection connection = connection();
                 PreparedStatement preparedStatement =
                         connection.prepareStatement(SQL)){
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,lastName);
                preparedStatement.setInt(3,age);
                preparedStatement.executeUpdate();
                System.out.println(name + " successfully added");
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }

    public void removeUserById(long id) {
    String SQL = "DELETE FROM users WHERE id = ?";
    try {
        Connection connection = util.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, (int) id);
        preparedStatement.executeUpdate();
    }catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    }

    public List<User> getAllUsers() {
        List<User> userList =new ArrayList<>();
        String SQL = "SELECT * FROM users";
        try {
            Connection connection = util.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setAge(resultSet.getByte("age"));

            userList.add(user);
                System.out.println(userList);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public void cleanUsersTable() {
        String SQL = "TRUNCATE users";
        try {
            Connection connection = util.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
