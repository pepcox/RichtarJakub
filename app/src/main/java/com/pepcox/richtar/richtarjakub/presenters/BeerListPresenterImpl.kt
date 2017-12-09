package com.pepcox.richtar.richtarjakub.presenters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.pepcox.richtar.richtarjakub.BeerAdapter
import com.pepcox.richtar.richtarjakub.ItemClickedInterface
import com.pepcox.richtar.richtarjakub.activites.BeerDetailActivity
import com.pepcox.richtar.richtarjakub.data.Beer

class BeerListPresenterImpl(private val context: Context) : ItemListPresenter<Beer> {

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showBeers(view: View, items: List<Beer>, listener: ItemClickedInterface<Beer>) {
        val recyclerView = view as RecyclerView
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = BeerAdapter(items, context, listener)
    }

    override fun showDetail(beer: Beer) {
        val bundle = Bundle()
        bundle.putSerializable(BeerDetailActivity.BEER_ARG, beer)

        val intent = Intent(context, BeerDetailActivity::class.java)
        intent.putExtras(bundle)
        context.startActivity(intent)
    }
}