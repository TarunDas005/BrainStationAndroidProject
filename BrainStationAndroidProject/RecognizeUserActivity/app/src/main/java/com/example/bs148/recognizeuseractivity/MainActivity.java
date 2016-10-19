package com.example.bs148.recognizeuseractivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.ActivityRecognition;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{

    GoogleApiClient mApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerEventBus();

        mApiClient = new GoogleApiClient.Builder(this)
                .addApi(ActivityRecognition.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        mApiClient.connect();
    }
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Intent intent = new Intent( this, ActivityRecognizedService.class );
        PendingIntent pendingIntent = PendingIntent.getService( this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT );
        ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates( mApiClient, 3000, pendingIntent );
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }



    @Override
    protected void onStart() {
        super.onStart();
        checkEventBusRegistration();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkEventBusRegistration();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mApiClient.disconnect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mApiClient.disconnect();
        unRegisterEventBus();
    }


    protected void registerEventBus()
    {
        try {
            if (!isEventBusRegistered()) {
                EventBus.getDefault().register(this);
            }
        } catch (Exception ex) {

        }

    }

    protected boolean isEventBusRegistered()
    {
        return EventBus.getDefault().isRegistered(this);
    }

    protected void unRegisterEventBus()
    {
        if (isEventBusRegistered()) {
            EventBus.getDefault().unregister(this);
        }
    }
    public void checkEventBusRegistration() {
        try {
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        } catch (Exception ex) {

        }
    }

    public void onEvent(CurrecntActivity currecntActivity){
        String s=currecntActivity.getCurrentWork();
        showToast(s);
    }

    public void showToast(String message) {
        final String msg = message;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
