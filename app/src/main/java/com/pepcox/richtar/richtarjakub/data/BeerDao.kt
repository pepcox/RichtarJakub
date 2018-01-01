package com.pepcox.richtar.richtarjakub.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface BeerDao {
    @get:Query("SELECT * FROM favorite_beers")
    val all: List<Beer>

    @Query("SELECT * FROM favorite_beers WHERE id IN (:beerIds)")
    fun loadAllByIds(beerIds: IntArray): List<Beer>

    @Query("SELECT * FROM favorite_beers WHERE name LIKE :name AND " + "image LIKE :image LIMIT 1")
    fun findByName(name: String, image: String): Beer

    @Insert
    fun insert(beer: Beer)

    @Query("DELETE FROM favorite_beers WHERE name LIKE :beer")
    fun deleteDoPice(beer: String)
}