package com.pepcox.richtar.richtarjakub.network

interface BeerDbApi {
    fun findByName(name: String, image: String): Boolean

    fun <E> insertBeer(beer: E)

    fun deleteBeer(beerName: String)
}