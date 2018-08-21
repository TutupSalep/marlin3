package com.rakasettya.marlin3.apps.splash;

public interface SplashView {

    void onSplashLoad();

    void showProgress(boolean isShow);

    void gotoMain();
//    void gotoMain(String uid);

    void showError(String message);
}
