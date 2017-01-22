package com.example.singgih.chatappsexample.SplashScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.singgih.chatappsexample.Controller.SplashScreenController;
import com.example.singgih.chatappsexample.Model.Chat;
import com.example.singgih.chatappsexample.R;

import io.realm.Realm;

public class SplashScreen extends SplashScreenController {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Realm.init(this);

        //Initiate real with it's default
        realm = Realm.getDefaultInstance();

        //Get list chat from WS
        getChatList(realm, this);

    }
}
