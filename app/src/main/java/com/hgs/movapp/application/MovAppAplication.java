package com.hgs.movapp.application;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;
import com.facebook.stetho.Stetho;
import com.hgs.movapp.di.components.ApplicationComponent;
import com.hgs.movapp.di.components.DaggerApplicationComponent;
import com.hgs.movapp.di.modules.ApplicationModule;

public class MovAppAplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this, true);
        Stetho.initializeWithDefaults(this);
        this.initializeInjector();

    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


}

