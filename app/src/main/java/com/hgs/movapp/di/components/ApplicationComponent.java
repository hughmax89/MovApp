package com.hgs.movapp.di.components;

import android.content.Context;

import com.hgs.domain.interface_adapters.PostExecutionThread;
import com.hgs.domain.interface_adapters.ThreadExecutor;
import com.hgs.movapp.base.BaseActivity;
import com.hgs.movapp.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    //IStoreRepository storeRepository();





}
