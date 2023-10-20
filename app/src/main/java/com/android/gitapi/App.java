package com.android.gitapi;

import android.app.Application;

import com.android.gitapi.presentation.di.AppComponent;
import com.android.gitapi.presentation.di.DaggerAppComponent;

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
