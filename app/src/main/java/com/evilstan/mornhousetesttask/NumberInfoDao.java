package com.evilstan.mornhousetesttask;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NumberInfoDao {

    @Query("SELECT count(*) FROM historyDb")
    int getDataBaseSize();

    @Query("SELECT*FROM historyDb")
    List<NumberInfo> getHistory();

    @Query("SELECT*FROM historyDb WHERE number =:number")
    NumberInfo getByNumber(int number);

    @Insert
    void insert(NumberInfo numberInfo);

    @Update
    void update(NumberInfo numberInfo);

    @Delete
    void delete(NumberInfo numberInfo);
}
