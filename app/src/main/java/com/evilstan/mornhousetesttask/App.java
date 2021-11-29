package com.evilstan.mornhousetesttask;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static App instance;
    private AppDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        dataBase = Room.databaseBuilder(this, AppDataBase.class, "history_database").allowMainThreadQueries().build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDataBase getDataBase() {
        return dataBase;
    }
}
