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
public class GenreDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/curs";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Zakazaka12345";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

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

}