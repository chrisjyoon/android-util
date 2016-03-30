package com.chrisjyoon.androidutil;

import android.app.Application;

import com.chrisjyoon.androidutil.inject.AppComponent;
import com.chrisjyoon.androidutil.inject.AppModule;
import com.chrisjyoon.androidutil.inject.DaggerAppComponent;
import com.chrisjyoon.androidutil.inject.NetModule;


/**
 * Created by chris on 2016. 3. 22..
 *
 */
public class MyApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        // Dagger%COMPONENT_NAME%
        mAppComponent = DaggerAppComponent.builder()
//                 list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule("http://t-save.adsync.co.kr"))
                .build();

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
//        mAppComponent = com.codepath.dagger.components.DaggerNetComponent.create();


    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
