package com.pepcox.richtar.richtarjakub.network

import com.pepcox.richtar.richtarjakub.data.Beer
import com.pepcox.richtar.richtarjakub.data.BeerDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RichtarApi {
    @GET("/api_richtar.php")
    fun getBeers(): Call<List<Beer>>

    @GET("/api_richtar_detail.php")
    fun getBeerDetail(@Query("beer") url: String): Call<BeerDetail>
}