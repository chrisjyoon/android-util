package com.chrisjyoon.androidutil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chrisjyoon.library.DeviceUtil;
import com.chrisjyoon.library.Logger;
import com.chrisjyoon.library.MyUtil;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Logger.d("onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        TextView tvNavHeight = (TextView) rootView.findViewById(R.id.nav_height);
        String navHeight = "Navigation bar height = " + DeviceUtil.getNavBarHeight(getContext());
        tvNavHeight.setText(navHeight);

        return rootView;
    }
}
