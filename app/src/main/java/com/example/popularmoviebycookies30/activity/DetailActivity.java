package com.example.popularmoviebycookies30.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.popularmoviebycookies30.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView MoviePosterPath, MovieBackdropPath;
    private TextView MovieTitle, MovieOverView, MovieLanguage, MovieRelease, MovieVoteAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        MovieTitle.setText(getIntent().getStringExtra("judulId"));
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+ getIntent().getStringExtra("backdropId")).into(MovieBackdropPath);
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+ getIntent().getStringExtra("imgMovieId")).into(MoviePosterPath);
        MovieLanguage.setText(getIntent().getStringExtra("bahasaId"));
        MovieRelease.setText(getIntent().getStringExtra("tahunId"));
        MovieVoteAverage.setText(String.valueOf(getIntent().getFloatExtra("bintangId",4)));
        MovieOverView.setText(getIntent().getStringExtra("overviewId"));
    }

    private void initView() {
        MovieTitle = findViewById(R.id.detailMovieTitle);
        MovieBackdropPath = findViewById(R.id.detailMovieBackdropPath);
        MoviePosterPath = findViewById(R.id.detailMoviePosterPath);
        MovieLanguage = findViewById(R.id.detailMovieLanguage);
        MovieRelease = findViewById(R.id.detailMovieRelease);
        MovieVoteAverage = findViewById(R.id.detailMovieBintang);
        MovieOverView = findViewById(R.id.detailMovieOverView);

    }
}