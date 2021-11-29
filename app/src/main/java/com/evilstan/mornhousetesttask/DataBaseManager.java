package com.evilstan.mornhousetesttask;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {
    Context context;

    public DataBaseManager(Context context) {
        this.context = context;
    }

    public List<NumberInfo> getHistory(){
        AppDataBase dataBase = App.getInstance().getDataBase();
        NumberInfoDao numberInfoDao = dataBase.numberInfoDao();

        if (numberInfoDao.getDataBaseSize() == 0) {
            return new ArrayList<>();
        }

        return numberInfoDao.getHistory();
    }
    //TODO Exception handling in DB querries
    public void putToHistory(NumberInfo numberInfo){
        AppDataBase dataBase = App.getInstance().getDataBase();
        NumberInfoDao numberInfoDao = dataBase.numberInfoDao();
        numberInfoDao.insert(numberInfo);
    }

    public NumberInfo getFromDbByNumber(int number){
        AppDataBase dataBase = App.getInstance().getDataBase();
        NumberInfoDao numberInfoDao = dataBase.numberInfoDao();
        return numberInfoDao.getByNumber(number);
    }

}
