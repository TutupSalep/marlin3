package com.rakasettya.marlin3.apps.test2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rakasettya.marlin3.R;
import com.rakasettya.marlin3.apps.test2.AdapterTest2.PostItemListener;
import com.rakasettya.marlin3.dagger.base.BaseActivity;
import com.rakasettya.marlin3.data.model.test2.BatamJohorBahru;
import com.rakasettya.marlin3.data.model.test2.JsonMember4Item;
import com.rakasettya.marlin3.data.model.test2.Response;
import java.util.ArrayList;
import javax.inject.Inject;

public class Test2Activity extends BaseActivity implements Test2View {

  @Inject
  Test2PresenterImp presenterImp;
  @BindView(R.id.rcvMarlin)
  RecyclerView rcvMarlin;
  private AdapterTest2 adapterTest2;

  public static void start(Context context) {
    Intent starter = new Intent(context, Test2Activity.class);
    starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(starter);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test_2);
    ButterKnife.bind(this);
    adapterTest2 = new AdapterTest2(this, new ArrayList<JsonMember4Item>(0), new PostItemListener() {
      @Override
      public void onPostClickListener(int id) {
      }
    });
    rcvMarlin.setHasFixedSize(true);
    rcvMarlin.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    rcvMarlin.setLayoutManager(new LinearLayoutManager(this));
    rcvMarlin.setAdapter(adapterTest2);
    presenterImp.getDataMarlin();
  }

  @Override
  public void data(Response object) {
    adapterTest2.UpdateTikets(object.getPayload().getBatamJohorBahru().getJsonMember4());
  }
}
