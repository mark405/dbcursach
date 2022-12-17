package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.Film;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class FilmDAO {
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

    public List<Film> index() {
        List<Film> films = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM FilmCollection";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Film film = new Film();

                film.setId(resultSet.getInt("FilmID"));
                film.setTitle(resultSet.getString("Title"));
                film.setGenre(resultSet.getInt("Genre"));
                film.setDuration(resultSet.getString("Duration"));
                film.setYear(resultSet.getString("IssueYear"));
                film.setRate(resultSet.getInt("Rate"));
                film.setCash(resultSet.getInt("Cash"));
                film.setEpisodes(resultSet.getInt("Episodes"));
                film.setSeasons(resultSet.getInt("Seasons"));
                film.setProducer(resultSet.getInt("Producer"));
                film.setScriptWriter(resultSet.getInt("ScriptWriter"));
                film.setDescription(resultSet.getString("Description"));


                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }
}

