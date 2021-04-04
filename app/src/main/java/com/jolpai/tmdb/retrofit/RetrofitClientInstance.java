package com.jolpai.tmdb.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 9/24/2018.
 */

public class RetrofitClientInstance {
    private static Retrofit retrofit;

    private static String ACCOUNT_ID="606855269ca759006e55340d";
    private static final String BASE_URL = "https://api.themoviedb.org/4/account/"+ACCOUNT_ID+"/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
