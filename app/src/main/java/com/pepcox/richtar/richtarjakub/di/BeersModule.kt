package com.pepcox.richtar.richtarjakub.di

import android.content.Context
import com.pepcox.richtar.richtarjakub.network.BeerApi
import com.pepcox.richtar.richtarjakub.network.RichtarApi
import com.pepcox.richtar.richtarjakub.network.RichtarRestApi
import com.pepcox.richtar.richtarjakub.presenters.BeerListPresenter
import com.pepcox.richtar.richtarjakub.presenters.BeerListPresenterImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class BeersModule(val context: Context) {

    @Provides
    @Singleton
    fun provideNewsAPI(redditApi: RichtarApi): BeerApi = RichtarRestApi(redditApi)

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RichtarApi = retrofit.create(RichtarApi::class.java)

    @Provides
    fun provideBeerListPresenter(): BeerListPresenter = BeerListPresenterImpl(context)
}