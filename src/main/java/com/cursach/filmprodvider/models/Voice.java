package com.cursach.filmprodvider.models;

/**
 * @author mark
 */
public class Voice {
    private int id;

    private String title;

    private String lang;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setLang(final String lang) {
        this.lang = lang;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLang() {
        return lang;
    }
}
