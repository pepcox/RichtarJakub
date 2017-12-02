package com.pepcox.richtar.richtarjakub.managers

import com.pepcox.richtar.richtarjakub.data.Beer
import com.pepcox.richtar.richtarjakub.network.BeerApi
import rx.Observable
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BeerManager @Inject constructor(private val api: BeerApi) {

    fun getBeers(): Observable<List<Beer>> {
        return Observable.create {
            subscriber ->

            val call = api.getBeers()
            try {
                val response = call.execute()
                if (response.isSuccessful) {
                    subscriber.onNext(response.body())
                }
            } catch (e: IOException) {
                subscriber.onError(Throwable(e.message))
            }
        }
    }
}