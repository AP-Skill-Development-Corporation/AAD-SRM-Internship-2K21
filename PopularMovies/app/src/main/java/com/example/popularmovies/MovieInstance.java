package com.example.popularmovies;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieInstance {
    public static final String BASE_URl="https://api.themoviedb.org/3/";
static Retrofit retrofit;
public static Retrofit getMoviesInstance(){
    if (retrofit==null){
        retrofit =new Retrofit.Builder().baseUrl(BASE_URl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    return retrofit;
}
}
