package com.rakasettya.marlin3.apps.test1;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rakasettya.marlin3.R;
import com.rakasettya.marlin3.dagger.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1Activity extends BaseActivity implements Test1View {

  ArrayList<String> dataprima;
  private RecyclerView.Adapter adapter;
  private RecyclerView.LayoutManager layoutManager;
  @BindView(R.id.rcvmarlinText)
  RecyclerView rcvmarlinText;

  public static void start(Context context) {
    Intent starter = new Intent(context, Test1Activity.class);
    context.startActivity(starter);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test_1);
    ButterKnife.bind(this);
    getPerhitunganPrima();
    layoutManager = new LinearLayoutManager(this);
    rcvmarlinText.setLayoutManager(layoutManager);
    adapter = new AdapterTest1(dataprima, this);
    rcvmarlinText.setAdapter(adapter);
  }

  private void getPerhitunganPrima() {
    dataprima = new ArrayList<String>();
    // inisiasi bilangan fibbonaci
    int [] angkafibbonaci = new int[20];
    angkafibbonaci[0] = 0;
    angkafibbonaci[1] = 1;

    // inisiasi bilangan prima
    int [] angkaprima = new int[7];
    angkaprima[0] =  2;
    angkaprima[1] =  3;
    angkaprima[2] =  5;
    angkaprima[3] =  13;
    angkaprima[4] =  89;
    angkaprima[5] =  233;
    angkaprima[6] =  1597;

    // Menghasilkan 2 data
    dataprima.add(0 + "Marlin");
    dataprima.add(1 + "Marlin");
    // Menghasilkan 20 angka fibonaci
    for (int i=2; i<angkafibbonaci.length;i++){
      // Awal Perulangan
      angkafibbonaci[i] = angkafibbonaci[i-1] + angkafibbonaci[i-2];
      boolean cekfibonaci = true;
      if (angkafibbonaci[i]%2==0){
        cekfibonaci = false;
      }
      if (!cekfibonaci){
        dataprima.remove(2 + "Marlin");
        dataprima.remove(3 + "Marlin");
        dataprima.remove(5 + "Marlin");
        dataprima.remove(13 + "Marlin");
        dataprima.remove(89 + "Marlin");
        dataprima.remove(233 + "Marlin");
        dataprima.remove(1597 + "Marlin");
        dataprima.add(angkafibbonaci[i] + "Marlin");
      } else {
        dataprima.add(angkafibbonaci[i] + "Marlin");
      }
      for (int n = 0; n < angkaprima.length; n++){
        if (angkafibbonaci[i] == angkaprima[n]){
          dataprima.add(angkafibbonaci[i] + "Marlin Booking");
        }
      }
    }
  }
}