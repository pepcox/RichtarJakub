package com.pepcox.richtar.richtarjakub.di

import android.content.Context
import com.pepcox.richtar.richtarjakub.data.Beer
import com.pepcox.richtar.richtarjakub.network.BeerApi
import com.pepcox.richtar.richtarjakub.network.RichtarApi
import com.pepcox.richtar.richtarjakub.network.RichtarRestApi
import com.pepcox.richtar.richtarjakub.presenters.BeerListPresenterImpl
import com.pepcox.richtar.richtarjakub.presenters.ItemListPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class BeersModule(private val context: Context) {

    @Provides
    @Singleton
    fun providesRestAPI(richtarApi: RichtarApi): BeerApi = RichtarRestApi(richtarApi)

    @Provides
    @Singleton
    fun providesRichtarApi(retrofit: Retrofit): RichtarApi = retrofit.create(RichtarApi::class.java)

    @Provides
    fun providesBeerListPresenter(): ItemListPresenter<Beer> = BeerListPresenterImpl(context)
}