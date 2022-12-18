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
public class ScriptWriterDAO extends TableBaseDao {

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

    public void add(final String name, final String surname) {
        try {
            String SQL = "INSERT INTO ScriptWriters(Name, Surname) VALUES(?, ?)";//insert

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
            String SQL = "DELETE FROM ScriptWriters WHERE ScriptWriterID = " + id;//insert

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
