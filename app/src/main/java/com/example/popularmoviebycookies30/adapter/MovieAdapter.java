package com.example.popularmoviebycookies30.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.popularmoviebycookies30.R;
import com.example.popularmoviebycookies30.activity.DetailActivity;
import com.example.popularmoviebycookies30.model.ResultsItem;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    public static Throwable t;

    private ArrayList<ResultsItem> resultsItems;
    private Context context;


    public MovieAdapter(ArrayList<ResultsItem> resultsItems, Context context) {
        this.resultsItems = resultsItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.judulId.setText(resultsItems.get(position).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/" + resultsItems.get(position).getPosterPath()).error(R.drawable.ic_launcher_background)
                .override(512,512)
                .into(holder.imgMovieId);
        holder.divKlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("judulId", resultsItems.get(position).getTitle());
                intent.putExtra("tahunId", resultsItems.get(position).getReleaseDate());
                intent.putExtra("bintangId", resultsItems.get(position).getVoteAverage());
                intent.putExtra("imgMovieId", resultsItems.get(position).getPosterPath());
                intent.putExtra("backdropId", resultsItems.get(position).getBackdropPath());
                intent.putExtra("overviewId", resultsItems.get(position).getOverview()) ;
                intent.putExtra("bahasaId", resultsItems.get(position).getOriginalLanguage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsItems.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMovieId;
        private TextView judulId;
        private RelativeLayout divKlik;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovieId = itemView.findViewById(R.id.itemMovieImage);
            judulId = itemView.findViewById(R.id.itemMovieTitle);
            divKlik = itemView.findViewById(R.id.div_klik);
        }
    }
}
