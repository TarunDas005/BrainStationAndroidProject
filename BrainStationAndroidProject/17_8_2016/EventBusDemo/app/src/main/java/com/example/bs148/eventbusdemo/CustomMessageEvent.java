package com.example.bs148.eventbusdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by BS148 on 8/17/2016.
 */
public class CustomMessageEvent{
    private String customMessage;

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }
}
