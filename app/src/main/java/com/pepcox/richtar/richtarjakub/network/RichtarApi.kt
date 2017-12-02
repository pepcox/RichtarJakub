package com.pepcox.richtar.richtarjakub.network

import com.pepcox.richtar.richtarjakub.data.Beer
import retrofit2.Call
import retrofit2.http.GET

interface RichtarApi {
    @GET("/api_richtar.php")
    fun getBeers(): Call<List<Beer>>
}