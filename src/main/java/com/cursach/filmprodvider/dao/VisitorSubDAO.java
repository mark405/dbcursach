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
public class VisitorSubDAO {
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
}
