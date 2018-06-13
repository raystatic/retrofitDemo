package com.example.rahul.retrofitdemo.ApiServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rahul on 14/6/18.
 */

public class ApiClient {

    public static final String BASE_URL="http://192.168.43.92/retrofit/";
    public static Retrofit retrofit=null;

    public static Retrofit getApiClient()
    {
        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
