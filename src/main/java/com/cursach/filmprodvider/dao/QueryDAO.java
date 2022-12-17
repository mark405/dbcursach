package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.FilmSub;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * @author mark
 */
@Component
public class QueryDAO {
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

    public String execute(final String SQL) {
        try {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM FilmSubs";
            statement.executeUpdate(SQL);

            return "OK";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

}
