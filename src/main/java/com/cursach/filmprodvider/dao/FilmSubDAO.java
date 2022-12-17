package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.FilmSub;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class FilmSubDAO {
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

    public List<FilmSub> index() {
        List<FilmSub> filmSubs = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM FilmSubs";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                FilmSub filmSub = new FilmSub();

                filmSub.setFilmId(resultSet.getInt("FilmID"));
                filmSub.setSubId(resultSet.getInt("SubID"));

                filmSubs.add(filmSub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filmSubs;
    }
}
