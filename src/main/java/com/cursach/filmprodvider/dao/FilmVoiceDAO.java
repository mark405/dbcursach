package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.FilmVoice;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class FilmVoiceDAO {
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

    public List<FilmVoice> index() {
        List<FilmVoice> filmVoices = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM VoicesOfFilms";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                FilmVoice filmVoice = new FilmVoice();

                filmVoice.setFilmId(resultSet.getInt("FilmID"));
                filmVoice.setVoiceId(resultSet.getInt("VoiceID"));

                filmVoices.add(filmVoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filmVoices;
    }
}

