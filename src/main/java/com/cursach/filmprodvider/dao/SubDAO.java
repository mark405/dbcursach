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
public class SubDAO extends TableBaseDao {

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

    public void add(final String type, final double price) {
        try {
            String SQL = "INSERT INTO Subs(TypeOfSub, Price) VALUES(?, ?)";//insert

            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, type);
            statement.setDouble(2, price);

            statement.addBatch();

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            String SQL = "DELETE FROM Subs WHERE SubID = " + id;//insert

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
