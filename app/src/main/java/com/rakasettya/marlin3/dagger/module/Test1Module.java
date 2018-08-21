package com.rakasettya.marlin3.dagger.module;

import com.rakasettya.marlin3.apps.main.MainActivity;
import com.rakasettya.marlin3.apps.main.MainPresenterImpl;
import com.rakasettya.marlin3.apps.main.MainView;
import com.rakasettya.marlin3.apps.test1.Test1Activity;
import com.rakasettya.marlin3.apps.test1.Test1PresenterImpl;
import com.rakasettya.marlin3.apps.test1.Test1View;
import com.rakasettya.marlin3.data.api.NetworkService;
import dagger.Module;
import dagger.Provides;
@Module
public class Test1Module {
  @Provides
  Test1View test1View(Test1Activity test1Activity){
    return test1Activity;
  }
  @Provides
  Test1PresenterImpl providetest1presenterimpl(Test1View test1View){
    return new Test1PresenterImpl(test1View);
  }
}
