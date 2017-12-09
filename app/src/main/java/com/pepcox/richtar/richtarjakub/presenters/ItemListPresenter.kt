package com.pepcox.richtar.richtarjakub.presenters

import android.view.View
import com.pepcox.richtar.richtarjakub.ItemClickedInterface

interface ItemListPresenter<T> {
    fun showDetail(beer: T)
    fun showBeers(view: View, items: List<T>, listener: ItemClickedInterface<T>)
    fun showError(error: String)
}