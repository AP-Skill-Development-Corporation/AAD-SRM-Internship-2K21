package com.example.popularmovies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPointInterface {
    @GET("movie/550?api_key=2b69a33e7c4f44bc6a99b8d616823bf3")
    Call<List<ResultsItem>> getAllData();
}
