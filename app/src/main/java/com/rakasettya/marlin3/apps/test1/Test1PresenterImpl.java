package com.rakasettya.marlin3.apps.test1;

import javax.inject.Inject;

public class Test1PresenterImpl {
  Test1View test1View;

  @Inject
  public Test1PresenterImpl(Test1View test1View) {
    this.test1View = test1View;
  }

  public void perhitunganPrima(){

  }
}