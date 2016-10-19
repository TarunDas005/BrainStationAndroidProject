package com.example.bs148.recognizeuseractivity;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by BS148 on 10/19/2016.
 */

public class ActivityRecognizedService extends IntentService {
    public ActivityRecognizedService() {
        super("ActivityRecognizedService");
    }

    public ActivityRecognizedService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(ActivityRecognitionResult.hasResult(intent)) {
            ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
            handleDetectedActivities( result.getProbableActivities() );
        }
    }

    private void handleDetectedActivities(List<DetectedActivity> probableActivities) {
        String s;
        for( DetectedActivity activity : probableActivities ) {
            s="";
            switch( activity.getType() ) {
                case DetectedActivity.IN_VEHICLE: {
                    s="ActivityRecogition"+ "In Vehicle: " + activity.getConfidence();
                    Log.e( "ActivityRecogition: ", "In Vehicle: " + activity.getConfidence() );
                    break;
                }
                case DetectedActivity.ON_BICYCLE: {
                    s="ActivityRecogition"+ "On Bicycle: " + activity.getConfidence();
                    Log.e( "ActivityRecogition: ", "On Bicycle: " + activity.getConfidence() );
                    break;
                }
                case DetectedActivity.ON_FOOT: {
                    s="ActivityRecogition"+ "On Foot: " + activity.getConfidence();
                    Log.e( "ActivityRecogition: ", "On Foot: " + activity.getConfidence() );
                    break;
                }
                case DetectedActivity.RUNNING: {
                    s="ActivityRecogition"+ "Running: " + activity.getConfidence();
                    Log.e( "ActivityRecogition: ", "Running: " + activity.getConfidence() );
                    break;
                }
                case DetectedActivity.STILL: {
                    s="ActivityRecogition: "+ "Still: " + activity.getConfidence();
                    Log.e( "ActivityRecogition", "Still: " + activity.getConfidence() );
                    break;
                }
                case DetectedActivity.TILTING: {
                    s="ActivityRecogition: "+ "Still: " + activity.getConfidence();
                    Log.e( "ActivityRecogition", "Tilting: " + activity.getConfidence() );
                    break;
                }
                case DetectedActivity.WALKING: {
                    s="ActivityRecogition: "+ "Walking: " + activity.getConfidence();
                    Log.e( "ActivityRecogition", "Walking: " + activity.getConfidence() );
                    if( activity.getConfidence() >= 75 ) {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                        builder.setContentText( "Are you walking?" );
                        builder.setSmallIcon( R.mipmap.ic_launcher );
                        builder.setContentTitle( getString( R.string.app_name ) );
                        NotificationManagerCompat.from(this).notify(0, builder.build());
                    }
                    break;
                }
                case DetectedActivity.UNKNOWN: {
                    s="ActivityRecogition: "+ "Unknown: " + activity.getConfidence();
                    Log.e( "ActivityRecogition", "Unknown: " + activity.getConfidence() );
                    break;
                }
            }
            if(activity.getConfidence()>=75){
                CurrecntActivity currecntActivity=new CurrecntActivity(s);
                EventBus.getDefault().post(currecntActivity);
            }

        }
    }
}
