package com.rakasettya.marlin3.apps.main;

import android.annotation.SuppressLint;
import android.content.Context;

import com.rakasettya.marlin3.data.api.NetworkService;
import com.rakasettya.marlin3.data.sqlite.dao.DAOSqlite;
import com.rakasettya.marlin3.data.sqlite.model.token.Token;
import com.rakasettya.marlin3.data.sqlite.model.user.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

public class MainPresenterImpl {
    MainView mainView;
    NetworkService networkService;

    @Inject
    public MainPresenterImpl(
        MainView mainView,
        NetworkService networkService) {
        this.mainView = mainView;
        this.networkService = networkService;
    }
}
