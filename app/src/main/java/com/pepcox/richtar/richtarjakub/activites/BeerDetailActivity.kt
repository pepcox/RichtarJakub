package com.pepcox.richtar.richtarjakub.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pepcox.richtar.richtarjakub.R
import com.pepcox.richtar.richtarjakub.data.Beer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_beer_detail.*

class BeerDetailActivity: AppCompatActivity() {

    companion object {
        const val BEER_ARG = "beer"
    }

    private lateinit var beer: Beer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_beer_detail)

        beer = intent.extras.getSerializable(BEER_ARG) as Beer

        title = beer.name
        Picasso.with(this)
                .load(beer.image)
                .into(beer_image)
    }
}