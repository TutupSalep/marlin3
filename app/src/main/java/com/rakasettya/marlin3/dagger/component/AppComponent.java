package com.rakasettya.marlin3.dagger.component;

import android.app.Application;

import com.rakasettya.marlin3.MyApplication;
import com.rakasettya.marlin3.dagger.module.ActivityBuilder;
import com.rakasettya.marlin3.dagger.module.AppModule;
import com.rakasettya.marlin3.dagger.module.FirebaseModule;
import com.rakasettya.marlin3.dagger.module.NetworkModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class,
        FirebaseModule.class,
        NetworkModule.class
})
public interface AppComponent  {

    @Component.Builder
    interface Builder {

        @BindsInstance Builder application(Application application);

        AppComponent build();

        Builder firebase(FirebaseModule firebaseModule);
        Builder network(NetworkModule networkModule);
    }

    void inject(MyApplication application);

}
