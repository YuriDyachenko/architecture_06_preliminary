package kurs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {
    public Book getById(int id) {
        Connection connection = AppContext.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM books WHERE id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Writer writer = AppContext.getInstance().getIdentityMap().
                        getWriterById(rs.getInt("writer_id"));
                Book book = new Book(writer, rs.getInt("id"),
                        rs.getString("name"), rs.getInt("unread"));
                System.out.println("...запрос книги к базе данных...");
                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
