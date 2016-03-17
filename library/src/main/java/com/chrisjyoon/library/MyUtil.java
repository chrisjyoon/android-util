package com.chrisjyoon.library;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by chris on 2016. 3. 4..
 *
 */
public class MyUtil {
    protected Context mContext;

    private static MyUtil sDeviceUtil;

    private static MyUtil getInstance(Context context) {
        if (sDeviceUtil == null) {
            sDeviceUtil = new MyUtil(context);
        }
        return sDeviceUtil;
    }

    public static MyUtil get(Context context) {
        return getInstance(context);
    }

    public static MyUtil get(Activity activity) {
        return getInstance(activity);
    }

    public static MyUtil get(Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalStateException("Fragment is not ready");
        }
        return getInstance(fragment.getActivity());
    }

    private MyUtil(Context context) {
        if (context == null) throw new IllegalStateException("Context cannot be null");
        mContext = context;
    }


}
