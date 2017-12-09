package com.pepcox.richtar.richtarjakub.managers

import com.pepcox.richtar.richtarjakub.data.Beer
import com.pepcox.richtar.richtarjakub.data.BeerDetail
import com.pepcox.richtar.richtarjakub.network.BeerApi
import retrofit2.Call
import rx.Observable
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BeerManager @Inject constructor(private val api: BeerApi) {

    fun getBeers(): Observable<List<Beer>> {
        return createObservable(api.getBeers())
    }

    fun getBeerDetail(url: String): Observable<BeerDetail> {
        return createObservable(api.getBeerDetail(url))
    }

    private fun <T>createObservable(call: Call<T>): Observable<T> {
        return Observable.create {
            subscriber ->

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