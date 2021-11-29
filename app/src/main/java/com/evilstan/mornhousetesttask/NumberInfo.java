package com.evilstan.mornhousetesttask;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "historyDb")

public class NumberInfo {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int number;
    private String description;

    public NumberInfo(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
