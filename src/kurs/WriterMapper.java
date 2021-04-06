package kurs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WriterMapper {
    public Writer getById(int id) {
        Connection connection = AppContext.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM writers WHERE id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Writer writer = new Writer(rs.getInt("id"),
                        rs.getString("name"), rs.getInt("unread"));
                System.out.println("...запрос писателя к базе данных...");
                return writer;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
