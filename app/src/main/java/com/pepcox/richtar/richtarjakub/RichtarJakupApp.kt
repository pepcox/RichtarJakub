package com.pepcox.richtar.richtarjakub

import android.app.Application
import com.pepcox.richtar.richtarjakub.data.BeerDbModule
import com.pepcox.richtar.richtarjakub.di.BeerComponent
import com.pepcox.richtar.richtarjakub.di.BeersModule
import com.pepcox.richtar.richtarjakub.di.DaggerBeerComponent

class RichtarJakupApp : Application() {

    companion object {
        lateinit var beersComponent: BeerComponent
    }

    override fun onCreate() {
        super.onCreate()
        beersComponent = DaggerBeerComponent.builder()
                .beersModule(BeersModule(this))
                .beerDbModule(BeerDbModule(this))
                .build()
    }
}