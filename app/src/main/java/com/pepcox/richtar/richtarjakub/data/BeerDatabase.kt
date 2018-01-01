package com.pepcox.richtar.richtarjakub.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Beer::class), version = 1)
abstract class BeerDatabase : RoomDatabase() {
    internal abstract fun beerDao(): BeerDao
}
