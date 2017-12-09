package com.pepcox.richtar.richtarjakub.di

import com.pepcox.richtar.richtarjakub.activites.BeerDetailActivity
import com.pepcox.richtar.richtarjakub.activites.BeersListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        BeersModule::class,
        NetworkModule::class)
)
interface BeerComponent {
    fun inject(newsFragment: BeersListActivity)
    fun inject(newsFragment: BeerDetailActivity)
}