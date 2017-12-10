package com.pepcox.richtar.richtarjakub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pepcox.richtar.richtarjakub.data.Beer
import com.pepcox.richtar.richtarjakub.presenters.BeerContract
import com.squareup.picasso.Picasso

class BeerAdapter(private val beers: List<Beer>, private val context: Context, private val beerPresenter: BeerContract.Presenter) : RecyclerView.Adapter<BeerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
            MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.beer_item, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val beer = beers[position]
        Picasso.with(context)
                .load(beer.image)
                .into(holder.imageView)
        holder.textView.text = beer.name
        holder.itemView.setOnClickListener {
            beerPresenter.openBeerDetail(beer)
        }
    }

    override fun getItemCount(): Int = beers.size

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.beer_id)
        val imageView: ImageView = view.findViewById(R.id.beer_pic)
    }
}
