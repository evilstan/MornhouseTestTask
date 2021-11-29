package com.evilstan.mornhousetesttask;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {NumberInfo.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract NumberInfoDao numberInfoDao();
}
