package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.Voice;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class VoiceDAO extends TableBaseDao {

    public List<Voice> index() {
        List<Voice> voices = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Voices";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Voice voice = new Voice();

                voice.setId(resultSet.getInt("VoicesID"));
                voice.setTitle(resultSet.getString("Title"));
                voice.setLang(resultSet.getString("Lang"));

                voices.add(voice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voices;
    }

    public void add(final String title, final String lang) {
        try {
            String SQL = "INSERT INTO Voices(Title, Lang) VALUES(?, ?)";//insert

            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, title);
            statement.setString(2, lang);

            statement.addBatch();

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            String SQL = "DELETE FROM Voices WHERE VoicesID = " + id;//insert

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
