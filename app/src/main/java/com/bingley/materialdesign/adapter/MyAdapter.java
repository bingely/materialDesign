package com.bingley.materialdesign.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bingley.materialdesign.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    /**
     * 数据
     */
    private List<Object> mDatas;

    public MyAdapter(List<Object> datas) {
        this.mDatas = datas;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyle_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), "good", Toast.LENGTH_SHORT).show();
            }
        });
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
