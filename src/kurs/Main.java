package kurs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        AppContext app = AppContext.getInstance();
        Connection connection = app.getConnection();
        if (connection != null) {
            try {
                System.out.println("---------- Все писатели в базе ----------");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT name FROM writers");
                while (rs.next()){
                    System.out.println(" " + rs.getString("name"));
                }
                rs.close();
                System.out.println("---------- Все книги в базе ----------");
                rs = statement.executeQuery("SELECT name FROM books");
                while (rs.next()){
                    System.out.println(" " + rs.getString("name"));
                }
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            System.out.println("---------- Получение писателя по id (два раза) ----------");
            System.out.println(app.getIdentityMap().getWriterById(1));
            System.out.println(app.getIdentityMap().getWriterById(1));

            System.out.println("---------- Получение книги по id (два раза) ----------");
            System.out.println(app.getIdentityMap().getBookById(2));
            System.out.println(app.getIdentityMap().getBookById(2));
        }

        app.closeConnection();
    }
}
