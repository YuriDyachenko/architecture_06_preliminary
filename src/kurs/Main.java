package kurs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        AppContext app = AppContext.getInstance();
        Connection connection = app.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, name, unread FROM writers");
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(app.getIdentityMap().getWriterById(1));
        System.out.println(app.getIdentityMap().getWriterById(1));

        app.closeConnection();
    }
}
