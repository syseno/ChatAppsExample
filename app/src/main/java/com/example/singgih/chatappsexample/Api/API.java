package com.example.singgih.chatappsexample.Api;

import com.example.singgih.chatappsexample.Model.Chat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by singg on 1/17/2017.
 */

public interface API {
    @GET("messages.json")
    Call<List<Chat>> getChatList();
}
