package com.chrisjyoon.library;

import android.util.Log;

/**
 * Created by chris on 2016. 3. 4..
 *
 */
public class Logger {
    private static final String TAG = "chris";

    public static void i(String msg) {
        Log.i(TAG, msg);
    }

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void e(String msg) {
        Log.e(TAG, msg);
    }

    public static void e(String msg, Throwable t) {
        Log.e(TAG, msg + ":" + t.getMessage());
    }
}
