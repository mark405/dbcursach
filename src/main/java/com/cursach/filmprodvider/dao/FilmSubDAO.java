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
public class FilmSubDAO extends TableBaseDao {


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

    public void add(String filmID, String subID) {
        try {
            String SQL = "INSERT INTO FilmSubs(FilmID, SubID) VALUES(?, ?)";//insert

            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, filmID);
            statement.setString(2, subID);

            statement.addBatch();

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String filmid, String subid) {
        try {
            String SQL = "DELETE FROM FilmSubs WHERE FilmID = " + filmid + " AND SubID = " + subid;//insert

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
