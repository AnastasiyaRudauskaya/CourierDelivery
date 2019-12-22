package by.project.courierexchange.connection;

import by.project.courierexchange.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TryDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String url = "jdbc:mysql://localhost:3306/exchange?serverTimezone=Europe/Moscow&useSSL=false";
        String pass = "root";


        try  {
            Connection connection = DriverManager.getConnection(url, pass,pass);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";

            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<User>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);
                users.add(new User(id, login, password));
            }
            System.out.println(users);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

