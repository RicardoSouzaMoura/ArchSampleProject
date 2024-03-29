package com.zimba.architecturesampleproject.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "asset_table")
public class Asset {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    public Asset(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
