package com.rakasettya.marlin3.apps.test2;

import android.annotation.SuppressLint;
import android.util.Log;
import com.rakasettya.marlin3.data.api.NetworkService;
import com.rakasettya.marlin3.data.model.signup.BodyLogin;
import com.rakasettya.marlin3.data.sqlite.dao.DAOSqlite;
import com.rakasettya.marlin3.data.sqlite.model.token.Token;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class Test2PresenterImp {
    Test2View test2View;
    NetworkService networkService;

    @Inject
    public Test2PresenterImp(Test2View test2View,
        NetworkService networkService) {
        this.test2View = test2View;
        this.networkService = networkService;
    }

    @SuppressLint("CheckResult")
    public void getDataMarlin() {
        networkService.getdataMarlin()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object -> {
                for (int i = 0;
                    i < object.getPayload().getBatamJohorBahru().getJsonMember4().size(); i++) {
                    Log.e("getDataMarlin", "Test2PresenterImp" + object.getPayload().getBatamJohorBahru().getJsonMember4().get(i).getProduct().toString());
                }
                Log.e("getDataMarlin", "Test2PresenterImp" + object.toString());
                Log.e("getDataMarlin", "Test2PresenterImp" + object.getPayload().toString());
                test2View.data(object);
            }, throwable -> {
                Log.e("getDataMarlin", "Test2PresenterImp" + throwable);
            });
    }
}
