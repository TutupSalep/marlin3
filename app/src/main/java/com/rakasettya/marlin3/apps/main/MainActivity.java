package com.rakasettya.marlin3.apps.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.rakasettya.marlin3.R;
import com.rakasettya.marlin3.apps.test1.Test1Activity;
import com.rakasettya.marlin3.apps.test2.Test2Activity;
import com.rakasettya.marlin3.dagger.base.BaseActivity;
import javax.inject.Inject;


public class MainActivity extends BaseActivity implements MainView {

  @Inject
  MainPresenterImpl presenter;
  @BindView(R.id.btnTest2)
  Button btnTest2;
  @BindView(R.id.btnTest1)
  Button btnTest1;

  public static void start(Context context) {
    Intent starter = new Intent(context, MainActivity.class);
    starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(starter);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
  }

  @OnClick({R.id.btnTest2, R.id.btnTest1})
  public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.btnTest2:
        Test2Activity.start(this);
        this.finish();
        break;
      case R.id.btnTest1:
        Test1Activity.start(this);
        this.finish();
        break;
    }
  }
}
