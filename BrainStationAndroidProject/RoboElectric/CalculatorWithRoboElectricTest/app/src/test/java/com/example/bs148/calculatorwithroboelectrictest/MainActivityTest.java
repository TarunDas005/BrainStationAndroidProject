package com.example.bs148.calculatorwithroboelectrictest;


import android.content.Intent;
import android.os.Build;
import android.widget.Button;

import org.apache.tools.ant.Main;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by BS148 on 9/20/2016.
 */
@Config(constants = BuildConfig.class,sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest{
    private Button firstActivityButton;
    private MainActivity activity;

    @Before
    public void setup(){
        //activity= Robolectric.setupActivity(MainActivity.class);
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        firstActivityButton= (Button) activity.findViewById(R.id.firstActivityButton);
    }

    @Test
    public void firstActivityStartOnClick() throws Exception{
        firstActivityButton.performClick();
        Intent expectedIntent=new Intent(activity,FirstActivity.class);
        ShadowActivity shadowActivity= shadowOf(activity);
        Intent actualIntent=shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
       /* firstActivityButton.performClick();
        Intent expectedIntent = new Intent(activity, FirstActivity.class);
        assertThat("Next activity started",shadowOf(RuntimeEnvironment.application).getNextStartedActivity(),is(notNullValue()));*/
    }
}
