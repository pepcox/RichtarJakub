package com.pepcox.richtar.richtarjakub.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BeerDao {
    @Query("SELECT * FROM Beer")
    List<Beer> getAll();

    @Query("SELECT * FROM Beer WHERE id IN (:beerIds)")
    List<Beer> loadAllByIds(int[] beerIds);

    @Query("SELECT * FROM Beer WHERE name LIKE :name LIMIT 1")
    Beer findByName(String name);

    @Insert
    void insert(Beer beer);

    @Delete
    void delete(Beer beer);
}
