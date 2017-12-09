package com.pepcox.richtar.richtarjakub.presenters

import android.view.View
import com.pepcox.richtar.richtarjakub.ItemClickedInterface
import com.pepcox.richtar.richtarjakub.data.Beer

interface BeerListPresenter {
    fun showDetail(beer: Beer)
    fun showBeers(view: View, beers: List<Beer>, listener: ItemClickedInterface)
    fun showError(error: String)
}