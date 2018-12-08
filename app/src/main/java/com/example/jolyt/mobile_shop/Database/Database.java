package com.example.jolyt.mobile_shop.Database;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Database extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("database.shopping").build();
        Realm.setDefaultConfiguration(config);
    }}
