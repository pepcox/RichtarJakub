package com.pepcox.richtar.richtarjakub.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BeerDao {
    @Query("SELECT * FROM favorite_beers")
    List<Beer> getAll();

    @Query("SELECT * FROM favorite_beers WHERE id IN (:beerIds)")
    List<Beer> loadAllByIds(int[] beerIds);

    @Query("SELECT * FROM favorite_beers WHERE name LIKE :name AND "
            + "image LIKE :image LIMIT 1")
    Beer findByName(String name, String image);

    @Insert
    void insert(Beer beer);

    @Delete
    void delete(Beer beer);

    @Query("DELETE FROM favorite_beers WHERE name LIKE :beer")
    void deleteDoPice(String beer);
}
