package com.bingley.materialdesign.topic.pullreflsh;

import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.adapter.MyAdapter;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.topic.pullreflsh.jdong.JdRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2016/12/21.
 */

public class PulllistRefshFragment extends BaseFragment{
    /**
     * 列表
     */
    @Bind(R.id.test_recycler_view)
    RecyclerView mRecyclerView;

    /**
     * 下拉刷新
     */
    @Bind(R.id.test_recycler_view_frame)
    JdRefreshLayout mLayout;

    /**
     * 布局管理器
     */
    RecyclerView.LayoutManager mManager;

    /**
     * 数据
     */
    private List<Object> mDatas;

    /**
     * 适配器
     */
    private MyAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.ptr_content_main;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);



    }

    @Override
    protected void initData() {
        super.initData();
        // 加的是一些死数据
        mDatas = new ArrayList<>();
        for (int i= 0;i<5;i++) {
            mDatas.add(new Object());
        }

        mManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mManager);
        mAdapter = new MyAdapter(mDatas);
        mRecyclerView.setAdapter(mAdapter);


        mLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                dosth();
            }
        });

    }

    private void dosth() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }


            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                mDatas.add(new Object());
                mAdapter.notifyDataSetChanged();
                mLayout.refreshComplete();
            }
        }.execute();
    }
}
