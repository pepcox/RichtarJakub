package com.pepcox.richtar.richtarjakub.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pepcox.richtar.richtarjakub.R

class BeerDetailActivity: AppCompatActivity() {

    companion object {
        const val NAME_ARG = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_beer_detail)

        title = intent.extras.getString(NAME_ARG)
    }
}