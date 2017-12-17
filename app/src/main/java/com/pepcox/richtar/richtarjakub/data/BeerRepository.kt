package com.pepcox.richtar.richtarjakub.data

class BeerRepository(val beerDao: BeerDao) {

    fun getBeerExistence(name: String, image: String): Boolean {
        return if (beerDao.findByName(name, image) != null) true else false
    }

    fun insertBeer(beer: Beer) {
        beerDao.insert(beer)
    }

    fun deleteBeer(beerName: String) {
        beerDao.deleteDoPice(beerName)
    }
}