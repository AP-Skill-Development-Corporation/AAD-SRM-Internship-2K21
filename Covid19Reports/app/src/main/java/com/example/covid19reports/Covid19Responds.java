package com.example.covid19reports;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Covid19Responds {
    static Retrofit retrofit;
    public static final String URL="https://api.covid19api.com/";
    public static Retrofit getInstance(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
