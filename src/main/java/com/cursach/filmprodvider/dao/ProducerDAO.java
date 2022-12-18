package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.Producer;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class ProducerDAO extends TableBaseDao {

    public List<Producer> index() {
        List<Producer> producers = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Producers";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Producer producer = new Producer();

                producer.setId(resultSet.getInt("ProducerID"));
                producer.setName(resultSet.getString("Name"));
                producer.setSurname(resultSet.getString("Surname"));

                producers.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producers;
    }

    public void add(final String name, final String surname) {
        try {
            String SQL = "INSERT INTO Producers(Name, Surname) VALUES(?, ?)";//insert

            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, name);
            statement.setString(2, surname);

            statement.addBatch();

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            String SQL = "DELETE FROM Producers WHERE ProducerID = " + id;//insert

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
