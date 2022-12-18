package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.Sub;
import com.cursach.filmprodvider.models.Visitor;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class VisitorDAO extends TableBaseDao{
    public List<Visitor> index() {
        List<Visitor> visitors = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Visitors";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Visitor visitor = new Visitor();

                visitor.setId(resultSet.getInt("VisitorID"));
                visitor.setName(resultSet.getString("Name"));
                visitor.setSurname(resultSet.getString("Surname"));
                visitor.setGenre(resultSet.getInt("FavGenre"));

                visitors.add(visitor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return visitors;
    }

    public void add(final String name, final String surname, final String genre) {
        try {
            String SQL = "INSERT INTO Visitors(Name, Surname, FavGenre) VALUES(?, ?, ?)";//insert

            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, genre);

            statement.addBatch();

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            String SQL = "DELETE FROM Visitors WHERE VisitorID = " + id;//insert

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
