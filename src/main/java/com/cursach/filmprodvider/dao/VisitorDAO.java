package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.Sub;
import com.cursach.filmprodvider.models.Visitor;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class VisitorDAO {
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

    public List<Visitor> index() {
        List<Visitor> visitors = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Visitors";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Visitor visitor = new Visitor();

                visitor.setId(resultSet.getInt("VisitorID"));
                visitor.setName(resultSet.getString("Name"));
                visitor.setSurname(resultSet.getString("Surname"));
                visitor.setGenre(resultSet.getInt("FavGenre"));

                visitors.add(visitor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return visitors;
    }
}
