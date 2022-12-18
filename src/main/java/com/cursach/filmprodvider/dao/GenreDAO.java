package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.Genre;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class GenreDAO extends TableBaseDao{

    public List<Genre> index() {
        List<Genre> genres = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Genres";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Genre genre = new Genre();

                genre.setId(resultSet.getInt("GenreID"));
                genre.setName(resultSet.getString("Name"));

                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genres;
    }

    public void add(final String name) {
        try {
            String SQL = "INSERT INTO Genres(Name) VALUES(?)";//insert

            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, name);

            statement.addBatch();

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            String SQL = "DELETE FROM Genres WHERE GenreID = " + id;//insert

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}