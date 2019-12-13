package com.hgs.movapp.di.components;

import android.app.Activity;

import com.hgs.movapp.di.PerActivity;
import com.hgs.movapp.di.modules.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
