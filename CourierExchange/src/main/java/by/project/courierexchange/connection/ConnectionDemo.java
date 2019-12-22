package by.project.courierexchange.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost::3306/exchange","root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("It is ok");


    }
}
