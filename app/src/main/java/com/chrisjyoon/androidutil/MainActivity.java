package com.chrisjyoon.androidutil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.chrisjyoon.androidutil.model.AppInfo;
import com.chrisjyoon.androidutil.network.NetworkApi;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.fab) FloatingActionButton fab;
    @Inject SharedPreferences mSharedPreferences;
    @Inject OkHttpClient mOkHttpClient;
    @Inject NetworkApi mNetworkApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MyApplication) getApplication()).getAppComponent().inject(this);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startFragment();

        boolean started = mSharedPreferences.getBoolean("IS_START", false);
    }

    @OnClick(R.id.fab)
    public void showSnackbar() {
        Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        Call<AppInfo> call = mNetworkApi.getAppInfo();
        call.enqueue(new Callback<AppInfo>() {
            @Override
            public void onResponse(Call<AppInfo> call, Response<AppInfo> response) {
                AppInfo appInfo = response.body();
                Log.d("chris", appInfo.getResultCode());
            }

            @Override
            public void onFailure(Call<AppInfo> call, Throwable t) {
                Log.d("chris", "call getAppInfo failed");
            }
        });
    }


    private void startFragment() {

    }

}
