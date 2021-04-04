package com.jolpai.tmdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.jolpai.tmdb.retrofit.API_Methods;
import com.jolpai.tmdb.retrofit.RetrofitClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        this.getSupportActionBar().setTitle("Movie List");
        recyclerView = findViewById(R.id.itemList);
        progressBar = findViewById(R.id.progressBar);
        getMovieList();
    }

    private void getMovieList(){
        API_Methods api_methods = RetrofitClientInstance.getRetrofitInstance().create(API_Methods.class);
        Call<Movies> myCall = api_methods.getFavoriteMovie();
        myCall.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                String gson = new Gson().toJson(response.body());
                Log.e("message", gson.toString());
                showMovies((ArrayList<Movies.Result>) response.body().getResults());
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.e("message", call.toString());
            }
        });
    }

    private void showMovies(ArrayList<Movies.Result> movieList){
        mAdapter = new MovieListAdapter(this, movieList);
        recyclerView.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MovieActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        progressBar.setVisibility(View.GONE);
    }
}