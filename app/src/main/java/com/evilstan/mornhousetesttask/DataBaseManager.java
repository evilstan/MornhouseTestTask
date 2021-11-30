package com.evilstan.mornhousetesttask;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {
//TODO database communicating in backthread

    public List<NumberInfo> getHistory() {
        AppDataBase dataBase = App.getInstance().getDataBase();
        NumberInfoDao numberInfoDao = dataBase.numberInfoDao();

        if (numberInfoDao.getDataBaseSize() == 0) {
            return new ArrayList<>();
        }

        return numberInfoDao.getHistory();
    }

    //TODO Exception handling in DB queries
    public void putToHistory(NumberInfo numberInfo) {
        AppDataBase dataBase = App.getInstance().getDataBase();
        NumberInfoDao numberInfoDao = dataBase.numberInfoDao();
        numberInfoDao.insert(numberInfo);
    }

    public NumberInfo getFromDbByNumber(int number) {
        AppDataBase dataBase = App.getInstance().getDataBase();
        NumberInfoDao numberInfoDao = dataBase.numberInfoDao();
        return numberInfoDao.getByNumber(number);
    }

}
