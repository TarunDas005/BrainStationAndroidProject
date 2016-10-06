package com.example.bs148.swipemenulistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleMenuDemoClick(View view) {
        startActivity(new Intent(this,SimpleMenuDemoActivity.class));
    }

    public void differentMenuDemoClick(View view) {
        startActivity(new Intent(this,DifferentDemoActivity.class));
    }
}
