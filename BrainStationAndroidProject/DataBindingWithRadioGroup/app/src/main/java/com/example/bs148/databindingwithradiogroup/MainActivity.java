package com.example.bs148.databindingwithradiogroup;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;

import com.example.bs148.databindingwithradiogroup.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        final PersonalInformation tarun=new PersonalInformation();
        tarun.setName("Tarun");
        tarun.setId("2012-1-60-005");
        tarun.setDepartment("CSE");
        final PersonalInformation borun=new PersonalInformation();
        borun.setName("Borun");
        borun.setId("2012-2-96-205");
        borun.setDepartment("EEE");
        binding.setPersonalInformation(borun);
        binding.nameSelector.rbNameBorun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    binding.setPersonalInformation(borun);
                }
            }
        });
        binding.nameSelector.rbNameTarun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    binding.setPersonalInformation(tarun);
                }
            }
        });
    }
}
