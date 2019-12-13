package com.hgs.movapp.component;

import com.hgs.movapp.di.PerActivity;
import com.hgs.movapp.di.components.ActivityComponent;
import com.hgs.movapp.di.components.ApplicationComponent;
import com.hgs.movapp.di.components.MovAppRoomModule;
import com.hgs.movapp.di.modules.ActivityModule;
import com.hgs.movapp.fragment.MainFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, MovAppRoomModule.class})
    interface MovAppRoomComponent extends ActivityComponent {
    void inject(MainFragment mainFragment);
}
