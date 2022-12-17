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
public class VoiceDAO {
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
}
