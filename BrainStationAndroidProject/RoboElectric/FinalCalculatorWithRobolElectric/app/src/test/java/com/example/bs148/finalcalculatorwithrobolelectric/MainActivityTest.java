package com.example.bs148.finalcalculatorwithrobolelectric;

import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by BS148 on 9/20/2016.
 */
@Config(constants = BuildConfig.class,sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private EditText firstNumberEditText,secondNumberEditText;
    private Button addButton,subButton;
    private TextView resultTextView;
    private double firstNumber,secondNumber;
    private MainActivity activity;
    @Before
    public void setup(){
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        firstNumberEditText= (EditText) activity.findViewById(R.id.firstNumberEditText);
        secondNumberEditText= (EditText) activity.findViewById(R.id.secondNumberEditText);
        addButton= (Button) activity.findViewById(R.id.addButton);
        subButton= (Button) activity.findViewById(R.id.subButton);
        resultTextView= (TextView) activity.findViewById(R.id.resultTextView);

        firstNumberEditText.setText("5");
        secondNumberEditText.setText("7");
    }

    @Test
    public void isNotEmpty(){
        assertTrue("EditText Not null",!"".equals(firstNumberEditText.getText().toString()));
        assertTrue("EditText Not null",!"".equals(secondNumberEditText.getText().toString()));

        assertThat(resultTextView.getText().toString()).isEqualTo("Result");
    }
}
