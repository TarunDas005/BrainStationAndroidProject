package com.example.bs148.firebaseuserauthentication;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by BS148 on 9/19/2016.
 */
public class FirebaseUserAuthentiation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
