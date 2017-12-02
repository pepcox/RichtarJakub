package com.pepcox.richtar.richtarjakub.di

import com.pepcox.richtar.richtarjakub.activites.ScrollingActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        BeersModule::class,
        NetworkModule::class)
)
interface BeerComponent {
    fun inject(newsFragment: ScrollingActivity)
}