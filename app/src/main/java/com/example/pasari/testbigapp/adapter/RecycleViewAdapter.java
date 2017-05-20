package com.example.pasari.testbigapp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.pasari.testbigapp.R;
import com.example.pasari.testbigapp.model.ListItemModel;

import java.util.List;


/**
 * Created by root on 3/1/17.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private Activity mActivity;
    private List<ListItemModel> listItemModels;

    public RecycleViewAdapter(Activity mActivity, List<ListItemModel> listItemModels) {
        this.mActivity = mActivity;
        this.listItemModels=listItemModels;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imv_album;
        TextView tv_title;
        TextView tv_time;
        TextView tv_short_description;


        public ViewHolder(View view) {
            super(view);
            imv_album=(ImageView)view.findViewById(R.id.imv_album);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_time = (TextView) view.findViewById(R.id.tv_time);
            tv_short_description = (TextView) view.findViewById(R.id.tv_short_description);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        //holder.tv_title.setText(listItemModels.get(position).getAlbum_name());
        //holder.tv_time.setText(listItemModels.get(position).getTime());
        //holder.tv_short_description.setText(listItemModels.get(position).getShort_description());


    }

    @Override
    public int getItemCount() {
        //return listItemModels.size();
        return 5;
    }


}
