package com.example.bs148.roboelectricfirsttest;

import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by BS148 on 9/20/2016.
 */
@Config(constants = BuildConfig.class,sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setUp(){
        activity= Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent(){
        TextView textView= (TextView) activity.findViewById(R.id.textView);
        assertNotNull("Textview could not found",textView);
        assertTrue("Textview contains incorrect text","Hello World!".equals(textView.getText().toString()));
    }
}
