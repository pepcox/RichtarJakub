package com.pepcox.richtar.richtarjakub.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Beer.class}, version = 1)
public abstract class BeerDatabase extends RoomDatabase {
    public abstract BeerDao beerDao();
}
