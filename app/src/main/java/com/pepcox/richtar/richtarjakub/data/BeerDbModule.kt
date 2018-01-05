package com.pepcox.richtar.richtarjakub.data

import android.arch.persistence.room.Room
import android.content.Context
import com.pepcox.richtar.richtarjakub.network.BeerDbApi
import dagger.Module
import dagger.Provides

@Module
class BeerDbModule constructor(private val context: Context) {

    class BeerRoomApi(context: Context): BeerDbApi {

        private var db: BeerDatabase =
                Room.databaseBuilder(context, BeerDatabase::class.java, "database-beers")
                        .allowMainThreadQueries().build()

        override fun findByName(name: String, image: String): Boolean {
            return db.beerDao().findByName(name, image) != null
        }

        override fun <E> insertBeer(beer: E) {
            when (beer) {
                is Beer -> {
                    db.beerDao().insert(beer)
                }
                is BeerHistory -> {
                    db.beerHistoryDao().insertBeerInHistory(beer)
                }
            }
        }

        override fun deleteBeer(beerName: String) {
            db.beerDao().deleteDoPice(beerName)
        }

    }

    @Provides
    fun beerDatabase(): BeerRepository = BeerRepository(BeerRoomApi(context))
}
