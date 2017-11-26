package com.pepcox.richtar.richtarjakub;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pepcox.richtar.richtarjakub.data.Beer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.MyViewHolder> {
    private List beers;
    private Context context;

    BeerAdapter(List beers, Context context) {
        this.beers = beers;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_item, null);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Beer beer = (Beer) beers.get(position);

        if(beer != null) {
            Picasso.with(context)
                    .load(beer.getImageUrl())
                    .into(holder.imageView);
            holder.textView.setText(beer.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return (null != beers ? beers.size() : 0);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        MyViewHolder(View view) {
            super(view);
            this.textView = view.findViewById(R.id.beer_id);
            this.imageView = view.findViewById(R.id.beer_pic);
        }
    }
}
