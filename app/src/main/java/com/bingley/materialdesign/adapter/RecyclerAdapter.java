package com.bingley.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseRecyclerAdapter;
import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2016/12/20.
 */

public class RecyclerAdapter extends BaseRecyclerAdapter {
    private Context mContext;

    public RecyclerAdapter(Context context) {
        this.mContext = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyle_item, parent,false));
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, Object data) {
        if (viewHolder instanceof MyViewHolder){
            /*Glide.with(mContext).load(data.getImageUrl()).into(((MyViewHolder) viewHolder).imageView);
            ((MyViewHolder) viewHolder).textView.setText(data.getText_content());*/
        }
    }


    class MyViewHolder extends RecyclerAdapter.Holder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
