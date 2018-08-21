package com.rakasettya.marlin3.dagger.module;

import com.rakasettya.marlin3.apps.barcode.BarcodeActivity;
import com.rakasettya.marlin3.apps.main.MainActivity;
import com.rakasettya.marlin3.apps.test1.Test1Activity;
import com.rakasettya.marlin3.apps.test2.Test2Activity;
import com.rakasettya.marlin3.apps.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {


  @ContributesAndroidInjector(modules = SplashActivityModule.class)
  abstract SplashActivity splashActivity();

  @ContributesAndroidInjector(modules = Test1Module.class)
  abstract Test1Activity test1Activity();

  @ContributesAndroidInjector(modules = MainActivityModul.class)
  abstract MainActivity mainActivity();

  @ContributesAndroidInjector(modules = BarcodeModule.class)
  abstract BarcodeActivity barcodeActivity();

  @ContributesAndroidInjector(modules = Test2Module.class)
  abstract Test2Activity test2Activity();
}
