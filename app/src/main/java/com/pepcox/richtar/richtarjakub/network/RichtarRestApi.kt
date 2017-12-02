package com.pepcox.richtar.richtarjakub.network

import com.pepcox.richtar.richtarjakub.data.Beer
import retrofit2.Call
import javax.inject.Inject

class RichtarRestApi @Inject constructor(private val beerApi: RichtarApi): BeerApi {

    override fun getBeers(): Call<List<Beer>> {
        return beerApi.getBeers()
    }
}