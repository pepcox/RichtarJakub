package com.pepcox.richtar.richtarjakub

interface ItemClickedInterface<in T> {
    fun onItemClicked(beer: T)
}