package com.cursach.filmprodvider.models;

/**
 * @author mark
 */
public class Film {
    private int id;
    private String title;
    private String genre;
    private String duration;
    private String year;
    private double rate;
    private int cash;
    private int episodes;
    private int seasons;
    private String producer;
    private String scriptWriter;
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
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

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setScriptWriter(String scriptWriter) {
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

    public String getGenre() {
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

    public String getProducer() {
        return producer;
    }

    public String getScriptWriter() {
        return scriptWriter;
    }

    public String getDescription() {
        return description;
    }
}
