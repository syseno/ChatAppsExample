package com.example.singgih.chatappsexample.BaseApplication;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by singg on 1/17/2017.
 */

public class BaseApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        //MultiDex
        MultiDex.install(this);

        super.onCreate();

        //Realm
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("chatApps.db")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config); // Make this Realm the default
    }
}
