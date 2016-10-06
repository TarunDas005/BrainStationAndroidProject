package com.example.bs148.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)

public class MainActivity extends RoboActivity {
    @InjectView(R.id.resultEditText) private EditText resultEditText;
    @InjectView(R.id.launchButton) private Button launchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RoboGuice.setUseAnnotationDatabases(false);
        EventBus.getDefault().register(this);
        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ChildActivity.class);
                startActivity(intent);
            }
        });
    }


    @Subscribe
    public void onEvent(CustomMessageEvent event){
        Log.d("Aronno","Event Fired "+ event.getCustomMessage());
        resultEditText.setText(event.getCustomMessage());
    }
    @Subscribe
    public void onEvent(CustomIdEvent event){
        Toast.makeText(getApplicationContext(),event.getId()+" "+event.getDept(),Toast.LENGTH_LONG).show();
    }
}
