package com.pepcox.richtar.richtarjakub.presenters

import com.pepcox.richtar.richtarjakub.data.Beer

interface BeerContract {

    interface View {
        fun showErrorView(error: String)
        fun showListView(beers: List<Beer>)
        fun showBeerDetail(beer: Beer)
    }

    interface Presenter {
        fun openBeerDetail(beer: Beer)
        fun onError(error: String)
        fun loadBeerList()
    }
}