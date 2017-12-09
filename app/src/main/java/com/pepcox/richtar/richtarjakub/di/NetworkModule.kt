package com.pepcox.richtar.richtarjakub.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://noskovic.sk/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
}