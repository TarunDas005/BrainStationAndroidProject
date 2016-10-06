package com.example.bs148.fireabaselistadapter;

import android.app.Application;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by BS148 on 9/21/2016.
 */
public class FireRun extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        /*Previous version
        Firebase.setAndroidContext(this);
        */

        /*newer version*/
        if(!FirebaseApp.getApps(this).isEmpty()){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }
}
