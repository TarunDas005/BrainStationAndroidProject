package com.example.bs148.bindingwithedittext;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by BS148 on 8/18/2016.
 */
public class TextChangeListner implements TextWatcher{
    TextInputLayout textInputLayout;
    String errorMessage;

    public TextChangeListner(TextInputLayout textInputLayout, String errorMessage) {
        this.textInputLayout = textInputLayout;
        this.errorMessage = errorMessage;
        this.textInputLayout.setError(errorMessage);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(s.toString().trim().length()>0){
            textInputLayout.setError(null);
            textInputLayout.setErrorEnabled(false);
        }else{
            textInputLayout.setError(errorMessage);
            textInputLayout.setErrorEnabled(true);
        }
    }
}
