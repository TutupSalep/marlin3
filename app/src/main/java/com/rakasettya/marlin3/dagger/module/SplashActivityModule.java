package com.rakasettya.marlin3.dagger.module;


import com.rakasettya.marlin3.data.remote.FirebaseAuthService;
import com.rakasettya.marlin3.apps.splash.SplashActivity;
import com.rakasettya.marlin3.apps.splash.SplashPresenterImpl;
import com.rakasettya.marlin3.apps.splash.SplashView;

import com.rakasettya.marlin3.data.sqlite.dao.DAOSqlite;
import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

    @Provides
    SplashView splashView(SplashActivity splashActivity){
        return splashActivity;
    }


    @Provides
    SplashPresenterImpl provideSplahPresenter(SplashView splashView){
        return new SplashPresenterImpl(splashView);
    }

}
