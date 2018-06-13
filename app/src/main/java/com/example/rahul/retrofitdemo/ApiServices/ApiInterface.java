package com.example.rahul.retrofitdemo.ApiServices;

import android.telecom.Call;

import com.example.rahul.retrofitdemo.model.UserLogin;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rahul on 14/6/18.
 */

public interface ApiInterface {

    @GET("list.php")
    retrofit2.Call<UserLogin> performLogin(@Query("username") String username, @Query("password") String password);

}
