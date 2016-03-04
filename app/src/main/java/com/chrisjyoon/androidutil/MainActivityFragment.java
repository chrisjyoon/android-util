package com.chrisjyoon.androidutil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chrisjyoon.library.DeviceUtil;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    DeviceUtil mDeviceUtil;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDeviceUtil = DeviceUtil.getInstance(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        TextView tvNavHeight = (TextView) rootView.findViewById(R.id.nav_height);
        String navHeight = "Navigation bar height = " + mDeviceUtil.getNavBarHeight();
        tvNavHeight.setText(navHeight);


        return rootView;
    }
}
