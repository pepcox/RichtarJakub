package com.pepcox.richtar.richtarjakub.data

class BeerRepository(val beerDao: BeerDbModule.BeerRoomApi) {

    fun getBeerExistence(name: String, image: String): Boolean {
        return beerDao.findByName(name, image)
    }

    fun <E> insertBeer(beer: E) {
        beerDao.insertBeer(beer)
    }

    fun deleteBeer(beerName: String) {
        beerDao.deleteBeer(beerName)
    }
}