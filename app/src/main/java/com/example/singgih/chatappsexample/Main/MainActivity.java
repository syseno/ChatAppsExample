package com.example.singgih.chatappsexample.Main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;

import com.example.singgih.chatappsexample.Adapter.ChatAdapter;
import com.example.singgih.chatappsexample.Controller.MainController;
import com.example.singgih.chatappsexample.Model.Chat;
import com.example.singgih.chatappsexample.R;

import java.util.List;

import io.realm.Realm;

public class MainActivity extends MainController {

    private ListView listView;
    private Realm realm;
    private List<Chat> chatList;
    private ChatAdapter chatAdapter;
    private EditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Every time when we'll define realm, must write this code to initiate with context
        Realm.init(this);

        // Initiate real with it's default
        realm = Realm.getDefaultInstance();

        // Get list chat from model
        chatList = realm.where(Chat.class).findAll();

        listView = (ListView) findViewById(R.id.listView);
        listView.setDivider(null);
        etMessage = (EditText) findViewById(R.id.etMessage);

        chatAdapter = new ChatAdapter(this, R.layout.own_message, chatList);
        listView.setAdapter(chatAdapter);
    }
}
