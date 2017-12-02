package com.pepcox.richtar.richtarjakub.network

import com.pepcox.richtar.richtarjakub.data.Beer
import com.pepcox.richtar.richtarjakub.data.BeerDetail
import retrofit2.Call
import javax.inject.Inject

class RichtarRestApi @Inject constructor(private val beerApi: RichtarApi): BeerApi {

    override fun getBeers(): Call<List<Beer>> {
        return beerApi.getBeers()
    }

    override fun getBeerDetail(url: String): Call<BeerDetail> {
        return beerApi.getBeerDetail(url)
    }
}