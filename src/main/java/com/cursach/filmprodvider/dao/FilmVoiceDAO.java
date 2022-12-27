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
public class FilmVoiceDAO extends TableBaseDao {

    public List<FilmVoice> index() {
        List<FilmVoice> filmVoices = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT Voices.Title, FilmCollection.Title\n" +
                    "FROM VoicesOfFilms\n" +
                    "INNER JOIN FilmCollection ON VoicesOfFilms.FilmID = FilmCollection.FilmID\n" +
                    "INNER JOIN Voices ON VoicesOfFilms.VoiceID = Voices.VoicesID";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                FilmVoice filmVoice = new FilmVoice();

                filmVoice.setFilm(resultSet.getString("FilmCollection.Title"));
                filmVoice.setVoice(resultSet.getString("Voices.Title"));

                filmVoices.add(filmVoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filmVoices;
    }

    public void add(String filmId, String voiceId) {
        try {
            String SQL = "INSERT INTO VoicesOfFilms(FilmID, VoiceID) VALUES(?, ?)";//insert

            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, filmId);
            statement.setString(2, voiceId);

            statement.addBatch();

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String filmid, String voiceid) {
        try {
            String SQL = "DELETE FROM VoicesOfFilms WHERE FilmID = " + filmid + " AND VoiceID = " + voiceid;//insert

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

