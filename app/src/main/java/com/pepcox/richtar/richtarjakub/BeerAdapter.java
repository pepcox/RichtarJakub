package com.pepcox.richtar.richtarjakub;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pepcox.richtar.richtarjakub.data.Beer;
import com.squareup.picasso.Picasso;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.MyViewHolder> {
    private List beers;
    private Context context;

    @IntDef({ViewType.BEER, ViewType.CREDITS})
    @Retention(RetentionPolicy.SOURCE)
    @interface ViewType {
        int BEER = 0;
        int CREDITS = 1;
    }


    public BeerAdapter(List beers, Context context) {
        this.beers = beers;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == ViewType.BEER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_item, null);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.credits_item, null);
        }

        return new MyViewHolder(view);
    }

    @Override
    public int getItemViewType(final int position) {
        if (position > beers.size()) {
            return ViewType.CREDITS;
        } else {
            return ViewType.BEER;
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String text;
        if (position < beers.size()) {
            final Beer beer = (Beer) beers.get(position);
            text = beer.getName();
            Picasso.with(context)
                    .load(beer.getImage())
                    .into(holder.imageView);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), beer.getDetail(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            text = context.getString(R.string.credits);
            Picasso.with(context)
                    .load(R.drawable.doge)
                    .into(holder.imageView);
        }
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return (null != beers ? beers.size() + 1 : 0);
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
