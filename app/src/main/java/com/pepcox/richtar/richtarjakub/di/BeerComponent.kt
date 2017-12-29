package com.pepcox.richtar.richtarjakub.di

import com.pepcox.richtar.richtarjakub.activites.BeerDetailActivity
import com.pepcox.richtar.richtarjakub.activites.BeersListActivity
import com.pepcox.richtar.richtarjakub.data.BeerDbModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        BeersModule::class,
        NetworkModule::class,
        BeerDbModule::class)
)
interface BeerComponent {
    fun inject(newsFragment: BeersListActivity)
    fun inject(newsFragment: BeerDetailActivity)
}