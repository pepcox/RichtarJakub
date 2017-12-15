package com.pepcox.richtar.richtarjakub.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BeerDao {
    @Query("SELECT * FROM user")
    List<Beer> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<Beer> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    Beer findByName(String first, String last);

    @Insert
    void insertAll(Beer... users);

    @Delete
    void delete(Beer user);
}
