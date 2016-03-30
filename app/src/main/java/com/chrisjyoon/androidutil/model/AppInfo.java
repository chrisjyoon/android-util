package com.chrisjyoon.androidutil.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chris on 30/03/2016.
 *
 */
public class AppInfo {
    @SerializedName("result_code")
    String mResultCode;

    public String getResultCode() {
        return mResultCode;
    }
}
