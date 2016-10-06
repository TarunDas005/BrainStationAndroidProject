package com.example.jannat.drawerandfragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment{


    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerEventBus();
    }

    @Override
    public void onResume() {
        super.onResume();
        registerEventBus();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

    protected void registerEventBus()
    {
        try {
            if (!isEventBusRegistered()) {
                EventBus.getDefault().register(getActivity());
            }
        } catch (Exception ex) {

        }

    }

    protected boolean isEventBusRegistered()
    {
        return EventBus.getDefault().isRegistered(getActivity());
    }

    protected void unRegisterEventBus()
    {
        if (isEventBusRegistered()) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        unRegisterEventBus();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unRegisterEventBus();
    }
}
