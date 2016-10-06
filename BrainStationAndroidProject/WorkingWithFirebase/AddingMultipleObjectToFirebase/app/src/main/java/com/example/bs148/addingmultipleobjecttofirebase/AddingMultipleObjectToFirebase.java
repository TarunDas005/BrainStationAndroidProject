package com.example.bs148.addingmultipleobjecttofirebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by BS148 on 9/19/2016.
 */
public class AddingMultipleObjectToFirebase extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}

