package com.rakasettya.marlin3.apps.splash;

import com.rakasettya.marlin3.data.sqlite.dao.DAOSqlite;
import com.google.firebase.auth.FirebaseUser;
import com.rakasettya.marlin3.data.model.UserModel;
import com.rakasettya.marlin3.data.remote.FirebaseAuthService;

import java.util.Calendar;

import java.util.List;
import javax.inject.Inject;

public class SplashPresenterImpl implements SplashPresenter {
    SplashView splashView;
    DAOSqlite daoSqlite;

    @Inject
    public SplashPresenterImpl(SplashView splashView) {
        this.splashView = splashView;
    }
    @Override
    public void loadSplash() {
        splashView.showProgress(true);
        splashView.gotoMain();
        }
}
