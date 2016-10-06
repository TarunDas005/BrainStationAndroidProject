package com.example.bs148.bindingwithedittext;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by BS148 on 8/18/2016.
 */
public class Information extends BaseObservable{
    private String name="";
    private String password="";

    public Information(String name, String password) {
        setName(name);
        setPassword(password);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.example.bs148.bindingwithedittext.BR.name);
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(com.example.bs148.bindingwithedittext.BR.password);
    }

    @Bindable
    public String getName() {
        return name;
    }
    @Bindable
    public String getPassword() {
        return password;
    }
}
