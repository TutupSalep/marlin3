package com.rakasettya.marlin3.apps.test1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.rakasettya.marlin3.R;
import com.rakasettya.marlin3.apps.test1.AdapterTest1.StringViewHolder;
import java.util.ArrayList;

public class AdapterTest1 extends RecyclerView.Adapter<AdapterTest1.StringViewHolder> {

  ArrayList<String> stringList;

  public AdapterTest1(ArrayList<String> stringList, Context context) {
    this.stringList = stringList;
  }

  @Override
  public StringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_list_test1, parent, false);
    StringViewHolder viewHolder = new StringViewHolder(v);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(StringViewHolder holder, int position) {
    holder.text.setText(stringList.get(position));
  }

  @Override
  public int getItemCount() {
    return stringList.size();
  }

  public static class StringViewHolder extends ViewHolder {
    TextView text;
    public StringViewHolder(View itemView) {
      super(itemView);
      text= (TextView) itemView.findViewById(R.id.textMarlin);
    }
  }
}
