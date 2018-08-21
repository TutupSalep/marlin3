package com.rakasettya.marlin3.dagger.module;

import android.app.Application;

import com.rakasettya.marlin3.data.remote.FirebaseAuthService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {


    @Provides
    @Singleton
    FirebaseAuthService provideFirebaseAuthService(Application application){
        return new FirebaseAuthService(application);
    }
}
