package com.pepcox.richtar.richtarjakub.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pepcox.richtar.richtarjakub.ItemClickedInterface
import com.pepcox.richtar.richtarjakub.R
import com.pepcox.richtar.richtarjakub.RichtarJakupApp
import com.pepcox.richtar.richtarjakub.data.Beer
import com.pepcox.richtar.richtarjakub.managers.BeerManager
import com.pepcox.richtar.richtarjakub.presenters.BeerListPresenter
import kotlinx.android.synthetic.main.activity_scrolling.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class BeersListActivity : AppCompatActivity(), ItemClickedInterface {

    override fun onItemClicked(beer: Beer) {
        beerPresenter.showDetail(beer)
    }

    @Inject
    lateinit var beerManager: BeerManager
    @Inject
    lateinit var beerPresenter: BeerListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        RichtarJakupApp.beersComponent.inject(this)

        beerManager.getBeers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    beerPresenter.showBeers(my_recycler_view, it, ScrollingActivity@this)
                },
                {
                    beerPresenter.showError(it.message!!)
                })
    }
}
