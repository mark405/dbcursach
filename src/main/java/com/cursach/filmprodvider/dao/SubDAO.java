package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.ScriptWriter;
import com.cursach.filmprodvider.models.Sub;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class SubDAO {

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

    public List<Sub> index() {
        List<Sub> subs = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Subs";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Sub sub = new Sub();

                sub.setId(resultSet.getInt("SubID"));
                sub.setType(resultSet.getString("TypeOfSub"));
                sub.setPrice(resultSet.getDouble("Price"));

                subs.add(sub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subs;
    }
}
