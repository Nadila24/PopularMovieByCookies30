package com.example.popularmoviebycookies30.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.popularmoviebycookies30.R;
import com.example.popularmoviebycookies30.adapter.MovieAdapter;
import com.example.popularmoviebycookies30.model.ResultsItem;
import com.example.popularmoviebycookies30.model.RoodMovieModel;
import com.example.popularmoviebycookies30.rest.ApiConfigMovie;
import com.example.popularmoviebycookies30.rest.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerviewId;

    private ArrayList<ResultsItem> resultsItems;
    private MovieAdapter movieAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        resultsItems = new ArrayList<>();
        getData();
        return view;
    }


    private void getData() {
        ApiService apiService = ApiConfigMovie.getApiService();
        apiService.getData()
                .enqueue(new Callback<RoodMovieModel>() {
                    @Override
                    public void onResponse(Call<RoodMovieModel> call, Response<RoodMovieModel> response) {
                        if (response.isSuccessful()) {
                            resultsItems = response.body().getResults();
                            movieAdapter = new MovieAdapter(resultsItems, getActivity());
                            movieAdapter.notifyDataSetChanged();
                            recyclerviewId.setAdapter(movieAdapter);
                            recyclerviewId.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                            recyclerviewId.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                        } else {
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RoodMovieModel> call, Throwable t) {
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView(View view) {
        recyclerviewId = view.findViewById(R.id.rvPopularMovies);
    }
}
