package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.FilmSub;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * @author mark
 */
@Component
public class QueryDAO extends TableBaseDao{

    public String execute(final String SQL) {
        try {
            Statement statement = connection.createStatement();
            //String SQL = "SELECT * FROM FilmSubs";
            statement.execute(SQL);

            return "OK";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

}
