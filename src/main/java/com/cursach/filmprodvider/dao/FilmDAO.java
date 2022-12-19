package com.cursach.filmprodvider.dao;

import com.cursach.filmprodvider.models.Film;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark
 */
@Component
public class FilmDAO extends TableBaseDao{

    public List<Film> index() {
        List<Film> films = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM FilmCollection";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Film film = new Film();

                film.setId(resultSet.getInt("FilmID"));
                film.setTitle(resultSet.getString("Title"));
                film.setGenre(resultSet.getInt("Genre"));
                film.setDuration(resultSet.getString("Duration"));
                film.setYear(resultSet.getString("IssueYear"));
                film.setRate(resultSet.getInt("Rate"));
                film.setCash(resultSet.getInt("Cash"));
                film.setEpisodes(resultSet.getInt("Episodes"));
                film.setSeasons(resultSet.getInt("Seasons"));
                film.setProducer(resultSet.getInt("Producer"));
                film.setScriptWriter(resultSet.getInt("ScriptWriter"));
                film.setDescription(resultSet.getString("Description"));


                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }

    public void add(String title, String genre, String duration, String year, String rating, String cash, String episodes, String seasons, String producer, String scriptwriter, String description) {
        try {
            String SQL = "INSERT INTO FilmCollection(Title, Genre, Duration, IssueYear, Rate, Cash, Episodes, Seasons, Producer, ScriptWriter, Description) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";//insert

            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, title);
            statement.setString(2, genre);
            statement.setString(3, duration);
            statement.setString(4, year);
            statement.setString(5, rating);
            statement.setString(6, cash);
            statement.setString(7, episodes);
            statement.setString(8, seasons);
            statement.setString(9, producer);
            statement.setString(10, scriptwriter);
            statement.setString(11, description);


            statement.addBatch();

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            String SQL = "DELETE FROM FilmCollection WHERE FilmID = " + id;//insert

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Film> sortByRating() {
        List<Film> films = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM FilmCollection ORDER BY Rate";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Film film = new Film();

                film.setId(resultSet.getInt("FilmID"));
                film.setTitle(resultSet.getString("Title"));
                film.setGenre(resultSet.getInt("Genre"));
                film.setDuration(resultSet.getString("Duration"));
                film.setYear(resultSet.getString("IssueYear"));
                film.setRate(resultSet.getInt("Rate"));
                film.setCash(resultSet.getInt("Cash"));
                film.setEpisodes(resultSet.getInt("Episodes"));
                film.setSeasons(resultSet.getInt("Seasons"));
                film.setProducer(resultSet.getInt("Producer"));
                film.setScriptWriter(resultSet.getInt("ScriptWriter"));
                film.setDescription(resultSet.getString("Description"));


                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }

    public Object sortByCash() {
        List<Film> films = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM FilmCollection ORDER BY Cash";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Film film = new Film();

                film.setId(resultSet.getInt("FilmID"));
                film.setTitle(resultSet.getString("Title"));
                film.setGenre(resultSet.getInt("Genre"));
                film.setDuration(resultSet.getString("Duration"));
                film.setYear(resultSet.getString("IssueYear"));
                film.setRate(resultSet.getInt("Rate"));
                film.setCash(resultSet.getInt("Cash"));
                film.setEpisodes(resultSet.getInt("Episodes"));
                film.setSeasons(resultSet.getInt("Seasons"));
                film.setProducer(resultSet.getInt("Producer"));
                film.setScriptWriter(resultSet.getInt("ScriptWriter"));
                film.setDescription(resultSet.getString("Description"));


                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }

    public Object sortByDescRating() {
        List<Film> films = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM FilmCollection ORDER BY Rate DESC";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Film film = new Film();

                film.setId(resultSet.getInt("FilmID"));
                film.setTitle(resultSet.getString("Title"));
                film.setGenre(resultSet.getInt("Genre"));
                film.setDuration(resultSet.getString("Duration"));
                film.setYear(resultSet.getString("IssueYear"));
                film.setRate(resultSet.getInt("Rate"));
                film.setCash(resultSet.getInt("Cash"));
                film.setEpisodes(resultSet.getInt("Episodes"));
                film.setSeasons(resultSet.getInt("Seasons"));
                film.setProducer(resultSet.getInt("Producer"));
                film.setScriptWriter(resultSet.getInt("ScriptWriter"));
                film.setDescription(resultSet.getString("Description"));


                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }

    public Object sortByDescCash() {
        List<Film> films = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM FilmCollection ORDER BY Cash DESC";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Film film = new Film();

                film.setId(resultSet.getInt("FilmID"));
                film.setTitle(resultSet.getString("Title"));
                film.setGenre(resultSet.getInt("Genre"));
                film.setDuration(resultSet.getString("Duration"));
                film.setYear(resultSet.getString("IssueYear"));
                film.setRate(resultSet.getInt("Rate"));
                film.setCash(resultSet.getInt("Cash"));
                film.setEpisodes(resultSet.getInt("Episodes"));
                film.setSeasons(resultSet.getInt("Seasons"));
                film.setProducer(resultSet.getInt("Producer"));
                film.setScriptWriter(resultSet.getInt("ScriptWriter"));
                film.setDescription(resultSet.getString("Description"));


                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }
}

