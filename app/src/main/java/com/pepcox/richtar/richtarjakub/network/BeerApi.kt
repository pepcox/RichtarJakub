package com.pepcox.richtar.richtarjakub.network

import com.pepcox.richtar.richtarjakub.data.Beer
import retrofit2.Call

interface BeerApi {
    fun getBeers(): Call<List<Beer>>
}