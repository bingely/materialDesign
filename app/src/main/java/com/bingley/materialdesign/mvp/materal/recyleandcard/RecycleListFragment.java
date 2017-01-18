package com.bingley.materialdesign.mvp.materal.recyleandcard;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * recycleview
 * 内容： 原生的写法，然后是引入库后的写法
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/21
 */

public class RecycleListFragment extends BaseFragment {
    @Bind(R.id.rc_list)
    RecyclerView mRcList;
    @Bind(R.id.spinner)
    Spinner mSpinner;


    private LinearLayoutManager mLayoutManager;

    // 模拟的数据集合
    private List<String> mData = new ArrayList<>();
    private RecycleAdapter mRecycleAdapter;
    private RecyleAdapter2 mRecyleAdapter2;


    @Override
    protected int getLayoutId() {
        return R.layout.frg_recyler;
    }


    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        mData.add("recycler");
        mData.add("gridview");
        mData.add("maaaaa");


        mLayoutManager = new LinearLayoutManager(getActivity());
        mRcList.setHasFixedSize(true);
        // 设置显示的动画
        mRcList.setItemAnimator(new DefaultItemAnimator());


        mRecycleAdapter = new RecycleAdapter(mData);
        //mRcList.setAdapter(mRecycleAdapter);

        mRecyleAdapter2 = new RecyleAdapter2(R.layout.rc_item,mData);
        mRcList.setAdapter(mRecyleAdapter2);
        mRecyleAdapter2.openLoadAnimation(BaseQuickAdapter.ALPHAIN);

        /*mRcList.setAdapter(new BaseQuickAdapter(String) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, Object o) {

            }
        });*/


        mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mRcList.setLayoutManager(new LinearLayoutManager(getActivity()));
                        break;
                    case 1:
                        mRcList.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                        break;
                    case 2:
                        mRcList.setLayoutManager(new StaggeredGridLayoutManager(3, 3));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick({R.id.btn_add, R.id.btn_del})
    public void onClick(View view) {
        int position;
        switch (view.getId()) {
            case R.id.btn_add:
                mData.add("Recycler");
                position = mData.size();
                if (position > 0) {
                    mRecyleAdapter2.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                    mRecyleAdapter2.notifyDataSetChanged();
                }
                break;
            case R.id.btn_del:
                position = mData.size();
                if (position > 0) {
                    mData.remove(position - 1);
                    mRecyleAdapter2.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                    mRecyleAdapter2.notifyDataSetChanged();
                }
                break;
        }
    }
}

