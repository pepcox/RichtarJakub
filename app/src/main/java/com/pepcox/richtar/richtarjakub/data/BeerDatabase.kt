package com.pepcox.richtar.richtarjakub.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Beer::class, BeerHistory::class), version = 2)
abstract class BeerDatabase : RoomDatabase() {
    abstract fun beerDao(): BeerDao
    abstract fun beerHistoryDao(): BeerHistoryDao
}
