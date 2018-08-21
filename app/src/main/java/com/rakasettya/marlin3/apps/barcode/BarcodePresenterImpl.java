package com.rakasettya.marlin3.apps.barcode;

import android.content.Context;
import com.rakasettya.marlin3.data.model.UserModel;
import com.rakasettya.marlin3.data.remote.FirebaseAuthService;
import com.google.firebase.firestore.DocumentSnapshot;

public class BarcodePresenterImpl {
    BarcodeView barcodeView;


    public BarcodePresenterImpl(BarcodeView barcodeView) {
        this.barcodeView = barcodeView;
    }

    public void OpenBarcodeScan(Context context){
        barcodeView.gotoBarcodeScan();
    }
}
