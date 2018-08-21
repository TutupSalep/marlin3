package com.rakasettya.marlin3.dagger.module;

import com.rakasettya.marlin3.apps.test2.Test2Activity;
import com.rakasettya.marlin3.apps.test2.Test2PresenterImp;
import com.rakasettya.marlin3.apps.test2.Test2View;
import com.rakasettya.marlin3.data.api.NetworkService;
import dagger.Module;
import dagger.Provides;

@Module
public class Test2Module {
    @Provides
    Test2View providetest2Activity(Test2Activity activity){
        return activity;
    }
    @Provides
    Test2PresenterImp providetest2Presenter(
        Test2View test2View,
        NetworkService networkService){
        return new Test2PresenterImp(test2View,networkService);
    }
}
