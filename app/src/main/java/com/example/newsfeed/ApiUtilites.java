package com.example.newsfeed;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilites {
    private static Retrofit retrofit = null;

    public static ApiInterface getApiInterface(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BaseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit.create(ApiInterface.class);
    }
}
