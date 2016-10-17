package com.example.bs148.placepickertest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView getPlaceTextView;
    private static int PLACE_PICKER_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPlaceTextView= (TextView) findViewById(R.id.tv_get_place);
        getPlaceTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PlacePicker.IntentBuilder builder=new PlacePicker.IntentBuilder();
                try {
                    Intent intent=builder.build(MainActivity.this);
                    startActivityForResult(intent,PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==PLACE_PICKER_REQUEST){
            if(resultCode==RESULT_OK){
                Place place=PlacePicker.getPlace(this,data);
                String address=String.format("Place: %s",place.getAddress());
                getPlaceTextView.setText(address);
                String x1= (String) place.getName();
                LatLng latLng=place.getLatLng();
                Locale x2=place.getLocale();
            }
        }
    }

    public void PickPlace(View view) {
        Intent intent=new Intent(MainActivity.this,PlaceDetectionTest.class);
        startActivity(intent);
    }
}
