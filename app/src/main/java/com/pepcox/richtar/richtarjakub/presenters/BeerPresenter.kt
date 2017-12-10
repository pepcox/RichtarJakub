package com.pepcox.richtar.richtarjakub.presenters

import com.pepcox.richtar.richtarjakub.data.Beer
import com.pepcox.richtar.richtarjakub.managers.BeerManager
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class BeerPresenter(private val beerView: BeerContract.View, val beerManager: BeerManager): BeerContract.Presenter {
    override fun loadBeerList() {
        beerManager.getBeers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    beers ->
                    beerView.showListView(beers)
                },
                {
                    beerView.showErrorView(it.message!!)
                })
    }

    override fun onError(error: String) {
        beerView.showErrorView(error)
    }

    override fun openBeerDetail(beer: Beer) {
        beerView.showBeerDetail(beer)
    }
}