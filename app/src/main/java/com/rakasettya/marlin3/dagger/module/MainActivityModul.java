package com.rakasettya.marlin3.dagger.module;

import com.rakasettya.marlin3.data.api.NetworkService;
import com.rakasettya.marlin3.apps.main.MainActivity;
import com.rakasettya.marlin3.apps.main.MainPresenterImpl;
import com.rakasettya.marlin3.apps.main.MainView;

import com.rakasettya.marlin3.data.sqlite.dao.DAOSqlite;
import com.rakasettya.marlin3.data.sqlite.model.user.User;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModul {
    @Provides
    MainView mainView(MainActivity mainActivity){
        return mainActivity;
    }
    @Provides
    MainPresenterImpl provideMainPresenterImp(MainView mainView, NetworkService networkService){
        return new MainPresenterImpl(mainView,networkService);
    }
}
