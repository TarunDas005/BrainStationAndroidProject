package com.example.bs148.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_child)
public class ChildActivity extends RoboActivity {

    @InjectView(R.id.triggerEventButton)private Button triggerEventButton;
    @InjectView(R.id.messageEditText)private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        triggerEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userText=messageEditText.getText().toString();
                CustomMessageEvent event=new CustomMessageEvent();
                event.setCustomMessage(userText);
                EventBus.getDefault().post(event);
                CustomIdEvent customIdEvent=new CustomIdEvent();
                customIdEvent.setId("2012-1-60-005");
                customIdEvent.setDept("CSE");
                EventBus.getDefault().post(customIdEvent);
                finish();
            }
        });

    }
}
