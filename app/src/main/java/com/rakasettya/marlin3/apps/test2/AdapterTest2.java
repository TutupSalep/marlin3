package com.rakasettya.marlin3.apps.test2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rakasettya.marlin3.R;
import com.rakasettya.marlin3.apps.test2.AdapterTest2.Holder;
import com.rakasettya.marlin3.data.model.test2.BatamJohorBahru;
import com.rakasettya.marlin3.data.model.test2.JsonMember4Item;
import java.util.ArrayList;
import java.util.List;

public class AdapterTest2 extends Adapter<Holder> {

  private List<JsonMember4Item> mTikets;
  private Context mContext;
  PostItemListener postItemListener;

  public AdapterTest2(Context context, ArrayList<JsonMember4Item> tiket,
      PostItemListener postItemListener) {
    this.mContext = context;
    this.mTikets = tiket;
    this.postItemListener = postItemListener;
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(mContext);
    View view = inflater.inflate(R.layout.item_list_test2, parent, false);
    Holder holder = new Holder(view, this.postItemListener);
    return holder;
  }

  @Override
  public void onBindViewHolder(Holder holder, int position) {
    JsonMember4Item ticket = getItem(position);
    holder.company.setText(ticket.getProduct().getCompany().getName());
  }

  @Override
  public int getItemCount() {
    return mTikets.size();
  }

  public class Holder extends ViewHolder implements OnClickListener {

    PostItemListener postItemListener;
    @BindView(R.id.company)
    TextView company;
    @BindView(R.id.bracketSeat)
    TextView bracketSeat;
    @BindView(R.id.port_code)
    TextView portCode;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.tvNumber)
    TextView tvNumber;
    @BindView(R.id.city_from)
    TextView cityFrom;
    @BindView(R.id.city_to)
    TextView cityTo;
    public Holder(View itemView, PostItemListener postItemListener) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      this.postItemListener = postItemListener;
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      JsonMember4Item tiket = getItem(getAdapterPosition());
      this.postItemListener.onPostClickListener(tiket.getId());
      notifyDataSetChanged();
    }
  }

  public interface PostItemListener {

    void onPostClickListener(int id);
  }

  private JsonMember4Item getItem(int adptPosition) {

    return mTikets.get(adptPosition);
  }

  public void UpdateTikets(List<JsonMember4Item> tiket) {
    mTikets = tiket;
    notifyDataSetChanged();
  }
}
