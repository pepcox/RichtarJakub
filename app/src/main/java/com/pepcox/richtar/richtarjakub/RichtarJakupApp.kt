package com.pepcox.richtar.richtarjakub

import android.app.Application
import com.pepcox.richtar.richtarjakub.di.*

class RichtarJakupApp : Application() {

    companion object {
        lateinit var beersComponent: BeerComponent
    }

    override fun onCreate() {
        super.onCreate()
        beersComponent = DaggerBeerComponent.builder().beersModule(BeersModule(this)).build()
    }
}