package com.pepcox.richtar.richtarjakub.data

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
abstract class CreateBeerDao constructor(private val applicationContext: Context): BeerDatabase() {

    @Provides
    fun beerDatabase(): RoomDatabase = Room.databaseBuilder(applicationContext,
            BeerDatabase::class.java, "database-beers").build()
}
