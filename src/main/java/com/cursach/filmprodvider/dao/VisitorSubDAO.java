package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.Sub;
import com.cursach.filmprodvider.models.VisitorSub;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class VisitorSubDAO extends TableBaseDao {

    public List<VisitorSub> index() {
        List<VisitorSub> visitorSubs = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM SubsOfVisitors";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                VisitorSub visitorSub = new VisitorSub();

                visitorSub.setSubID(resultSet.getInt("SubID"));
                visitorSub.setVisitorID(resultSet.getInt("VisitorID"));
                visitorSub.setStart(resultSet.getString("StartOfSub"));
                visitorSub.setEnd(resultSet.getString("EndOfSub"));
                visitorSub.setStatus(resultSet.getString("StatusOfSub"));


                visitorSubs.add(visitorSub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return visitorSubs;
    }

    public void add(final String subId, final String visitorId, final String start, final String end, final String status) {
        try {
            String SQL = "INSERT INTO SubsOfVisitors(subID, visitorID, StartOfSub, EndOfSub, StatusOfSub) VALUES(?, ?, ?, ?, ?)";//insert

            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, subId);
            statement.setString(2, visitorId);
            statement.setString(3, start);
            statement.setString(4, end);
            statement.setString(5, visitorId);


            statement.addBatch();

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String subid, String visitorid) {
        try {
            String SQL = "DELETE FROM SubsOfVisitors WHERE SubID = " + subid + " AND VisitorID = " + visitorid;//insert

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
