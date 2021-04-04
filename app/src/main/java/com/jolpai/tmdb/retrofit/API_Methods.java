package com.jolpai.tmdb.retrofit;

import com.jolpai.tmdb.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by User on 9/24/2018.
 */

public interface API_Methods {


    @Headers("authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3NWY1ZTdiNGY0MWU1MmZiYjljMmJjNDg1MDQwOGQ1OSIsInN1YiI6IjYwNjg1NTI2OWNhNzU5MDA2ZTU1MzQwZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.L_a0tbfARrSTjdTfJGcwP4W0xU62NfSJiYA2f3vEqx0")
    @GET("movie/favorites")
    Call<Movies> getFavoriteMovie(

    );
}
