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
public class ProducerDAO {

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
}
