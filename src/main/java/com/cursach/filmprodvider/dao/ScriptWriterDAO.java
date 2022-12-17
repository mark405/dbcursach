package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.Producer;
import com.cursach.filmprodvider.models.ScriptWriter;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class ScriptWriterDAO {

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

    public List<ScriptWriter> index() {
        List<ScriptWriter> scriptWriters = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM ScriptWriters";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                ScriptWriter scriptWriter = new ScriptWriter();

                scriptWriter.setId(resultSet.getInt("ScriptWriterID"));
                scriptWriter.setName(resultSet.getString("Name"));
                scriptWriter.setSurname(resultSet.getString("Surname"));

                scriptWriters.add(scriptWriter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scriptWriters;
    }
}
