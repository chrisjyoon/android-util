package com.chrisjyoon.androidutil.inject;

import com.chrisjyoon.androidutil.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by chris on 2016. 3. 21..
 *
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

}
