package com.cursach.filmprodvider.models;

/**
 * @author mark
 */
public class Film {
    private int id;
    private String title;
    private int genre;
    private String duration;
    private String year;
    private double rate;
    private int cash;
    private int episodes;
    private int seasons;
    private int producer;
    private int scriptWriter;
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public void setProducer(int producer) {
        this.producer = producer;
    }

    public void setScriptWriter(int scriptWriter) {
        this.scriptWriter = scriptWriter;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getYear() {
        return year;
    }

    public double getRate() {
        return rate;
    }

    public int getCash() {
        return cash;
    }

    public int getEpisodes() {
        return episodes;
    }

    public int getSeasons() {
        return seasons;
    }

    public int getProducer() {
        return producer;
    }

    public int getScriptWriter() {
        return scriptWriter;
    }

    public String getDescription() {
        return description;
    }
}
