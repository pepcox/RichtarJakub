package com.pepcox.richtar.richtarjakub.network

import com.pepcox.richtar.richtarjakub.data.Beer

interface BeerDbApi {
    fun findByName(name: String, image: String): Boolean

    fun insertBeer(beer: Beer)

    fun deleteBeer(beerName: String)
}