package com.chrisjyoon.androidutil.network;

import com.chrisjyoon.androidutil.model.AppInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chris on 30/03/2016.
 *
 */
public interface NetworkApi {
    @GET("/api/get_app_info.php")
    Call<AppInfo> getAppInfo();
}
