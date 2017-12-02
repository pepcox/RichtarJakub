package com.pepcox.richtar.richtarjakub.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.pepcox.richtar.richtarjakub.BeerAdapter
import com.pepcox.richtar.richtarjakub.R
import com.pepcox.richtar.richtarjakub.RichtarJakupApp
import com.pepcox.richtar.richtarjakub.managers.BeerManager
import kotlinx.android.synthetic.main.activity_scrolling.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class ScrollingActivity : AppCompatActivity() {

    @Inject
    lateinit var beerManager: BeerManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        RichtarJakupApp.beersComponent.inject(this)

        beerManager.getBeers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    my_recycler_view.hasFixedSize()
                    my_recycler_view.layoutManager = LinearLayoutManager(ScrollingActivity@this)
                    my_recycler_view.adapter = BeerAdapter(it, ScrollingActivity@ this)
                },
                {
                    Toast.makeText(ScrollingActivity@this, it.message, Toast.LENGTH_SHORT).show()
                })
    }
}
