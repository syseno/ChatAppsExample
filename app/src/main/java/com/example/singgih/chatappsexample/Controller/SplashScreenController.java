package com.example.singgih.chatappsexample.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.singgih.chatappsexample.Api.API;
import com.example.singgih.chatappsexample.Main.MainActivity;
import com.example.singgih.chatappsexample.Model.Chat;
import com.example.singgih.chatappsexample.Services.Service;
import com.example.singgih.chatappsexample.SplashScreen.SplashScreen;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by singg on 1/18/2017.
 */

public class SplashScreenController extends AppCompatActivity {

    // Method to get chat list from Web Service
    public void getChatList(final Realm realm, final Context context) {
        final API route = Service.getRetrofit().create(API.class);
        Call<List<Chat>> chatCall = route.getChatList();
        chatCall.enqueue(new Callback<List<Chat>>() {
            @Override
            //When success hit Web Service
            public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {
                // Read HTTP Response
                if (response.code() == 200) {
                    List<Chat> chatResponse = response.body();
                    if (chatResponse != null) {
                        if (chatResponse.size() != 0) {
                            // Save all object from WS to model
                            Chat.saveAllChat(realm, chatResponse);

                            // Go to main activity when all the object collected
                            Intent intent = new Intent(context, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "There's no new message", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Fail to get message", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Fail to get message", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            // When hitting Web Service get fail
            public void onFailure(Call<List<Chat>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fail to connect the server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
