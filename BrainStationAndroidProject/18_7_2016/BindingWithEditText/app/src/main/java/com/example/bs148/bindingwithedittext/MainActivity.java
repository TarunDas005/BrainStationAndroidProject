package com.example.bs148.bindingwithedittext;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.example.bs148.bindingwithedittext.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private Information information;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        information = new Information("Tarun", "2012-1-60-005");
        binding.setGetInformation(information);
        setEditTextListener();
        Toast.makeText(getApplicationContext(), information.getName() + " " + information.getPassword(), Toast.LENGTH_LONG).show();
    }


    private void setEditTextListener() {
        binding.etUserName.addTextChangedListener
                (new TextChangeListner(binding.tillUserName, getResourceString(R.string.userNameEmptyErrorMsg)));
        binding.etUserPassword.addTextChangedListener
                (new TextChangeListner(binding.tillUserPassword, getResourceString(R.string.passwordEmptyErrorMsg)));

    }

    public String getResourceString(int resourceId) {
        return getResources().getString(resourceId);
    }
}
