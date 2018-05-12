package adong.org.finedust.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import adong.org.finedust.R;
import adong.org.finedust.data.Dust;
import adong.org.finedust.data.DustList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.DustView>{
    List<DustList> dustViewslist;

    public MyAdapter(List<DustList> dustViewslist) {
        this.dustViewslist = dustViewslist;
    }

    @NonNull
    @Override
    public DustView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutview = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        DustView dustView = new DustView(layoutview);
        return dustView;
    }

    @Override
    public void onBindViewHolder(@NonNull DustView holder, int position) {
        holder.cardview_stationname.setText(dustViewslist.get(position).getStationName());
        holder.cardview_dusttime.setText(dustViewslist.get(position).getDataTime());
        holder.cardview_pm10value.setText(dustViewslist.get(position).getPm10Value());
        holder.cardview_pm25value.setText(dustViewslist.get(position).getPm25Value());
    }

    @Override
    public int getItemCount() {
        return dustViewslist.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DustView extends RecyclerView.ViewHolder {
        View itemView;
        TextView cardview_dusttime;
        TextView cardview_stationname;
        TextView cardview_pm10value;
        TextView cardview_pm25value;

        public DustView(View itemView) {
            super(itemView);
            cardview_dusttime = itemView.findViewById(R.id.cardview_dusttime);
            cardview_stationname = itemView.findViewById(R.id.cardview_stationnmae);
            cardview_pm10value = itemView.findViewById(R.id.cardview_pm10value);
            cardview_pm25value = itemView.findViewById(R.id.cardview_pm25value);
        }
    }
}

