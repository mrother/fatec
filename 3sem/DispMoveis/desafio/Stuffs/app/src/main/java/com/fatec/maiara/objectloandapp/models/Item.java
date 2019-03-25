package com.fatec.maiara.objectloandapp.models;

import android.icu.util.LocaleData;

import java.io.Serializable;

public class Item implements Serializable {

    private long id;
    private String name;
    private String description;
    private String date;

    public Item(long id , String name, String description, String date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Item(String name, String description, String date) {
        this(0, description,name, date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }
}
