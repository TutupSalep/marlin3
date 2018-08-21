package com.rakasettya.marlin3.dagger.module;

import com.rakasettya.marlin3.apps.barcode.BarcodeActivity;
import com.rakasettya.marlin3.apps.barcode.BarcodePresenterImpl;
import com.rakasettya.marlin3.apps.barcode.BarcodeView;
import dagger.Module;
import dagger.Provides;

@Module
public class BarcodeModule {

  @Provides
  BarcodeView barcodeView(BarcodeActivity barcodeActivity) {
    return barcodeActivity;
  }

  @Provides
  BarcodePresenterImpl provideBarcodePresenterImpl(BarcodeView barcodeView) {
    return new BarcodePresenterImpl(barcodeView);
  }


}
