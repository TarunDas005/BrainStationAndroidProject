package com.example.bs148.myfirebasedemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private Button mSendData;
    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        mRef=new Firebase("https://myfirebasedemoapp-62f30.firebaseio.com/");
        mSendData= (Button) findViewById(R.id.sendData);
        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Firebase mRefChild=mRef.child("Name");
                mRefChild.setValue("Aronno");

            }
        });
    }
}
