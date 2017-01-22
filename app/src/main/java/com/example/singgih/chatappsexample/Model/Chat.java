package com.example.singgih.chatappsexample.Model;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by singg on 1/17/2017.
 */

public class Chat extends RealmObject {
    @PrimaryKey
    private String message;
    private String sender;
    private boolean is_from_me;
    private String time;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public boolean is_from_me() {
        return is_from_me;
    }

    public void setIs_from_me(boolean is_from_me) {
        this.is_from_me = is_from_me;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static void deleteAllChat(Realm realm) {
        realm.beginTransaction();
        realm.delete(Chat.class);
        realm.beginTransaction();
    }

    public static void saveAllChat(Realm realm, List<Chat> chatList) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(chatList);
        realm.commitTransaction();
    }
}
