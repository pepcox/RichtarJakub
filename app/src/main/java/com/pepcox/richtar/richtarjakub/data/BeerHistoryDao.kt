package com.pepcox.richtar.richtarjakub.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface BeerHistoryDao {
    @get:Query("SELECT * FROM beer_history")
    val beerList: List<BeerHistory>

    @Query("SELECT * FROM beer_history WHERE name LIKE :name AND " + "image LIKE :image LIMIT 1")
    fun findByNameInHistory(name: String, image: String): BeerHistory

    @Insert
    fun insertBeerInHistory(beer: BeerHistory)
}