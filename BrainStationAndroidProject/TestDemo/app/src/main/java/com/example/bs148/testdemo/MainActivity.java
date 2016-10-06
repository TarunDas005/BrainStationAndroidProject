package com.example.bs148.testdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hashtable<Integer, String> source = new Hashtable<Integer,String>();
        source.put(1,"A");
        source.put(2,"C");
        source.put(1,"B");
        String s="A";
    }
}
