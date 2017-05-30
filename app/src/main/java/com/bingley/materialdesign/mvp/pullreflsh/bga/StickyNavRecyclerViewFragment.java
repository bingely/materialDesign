package com.bingley.materialdesign.mvp.pullreflsh.bga;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bingley.materialdesign.AppContext;
import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.bean.RefreshModel;
import com.bingley.materialdesign.view.Divider;

import java.util.List;

import butterknife.Bind;
import cn.bingoogolapple.androidcommon.adapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.androidcommon.adapter.BGAOnItemChildLongClickListener;
import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemLongClickListener;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * $Description:$
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/4/8
 */
public class StickyNavRecyclerViewFragment extends BaseFragment implements BGAOnRVItemClickListener, BGAOnRVItemLongClickListener, BGAOnItemChildClickListener, BGAOnItemChildLongClickListener ,BGARefreshLayout.BGARefreshLayoutDelegate {
    @Bind(R.id.data)
    RecyclerView mRecyclerView;

    private NormalRecyclerViewAdapter mAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recyclerview_sticky_nav;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        mRecyclerView.addItemDecoration(new Divider(mRootActivity));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(mApp, 2, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRootActivity, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        
        
        mAdapter = new NormalRecyclerViewAdapter(mRecyclerView);
        mAdapter.setOnRVItemClickListener(this);
        mAdapter.setOnRVItemLongClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        mAdapter.setOnItemChildLongClickListener(this);
    }


    @Override
    protected void initData() {
        super.initData();
        AppContext.getInstance().getEngine().loadInitDatas().enqueue(new Callback<List<RefreshModel>>() {
            @Override
            public void onResponse(Call<List<RefreshModel>> call, Response<List<RefreshModel>> response) {
                mAdapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<RefreshModel>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        return false;
    }

    @Override
    public void onRVItemClick(ViewGroup viewGroup, View view, int i) {
        
    }

    @Override
    public boolean onRVItemLongClick(ViewGroup viewGroup, View view, int i) {
        return false;
    }

    @Override
    public void onItemChildClick(ViewGroup viewGroup, View view, int i) {
        
    }

    @Override
    public boolean onItemChildLongClick(ViewGroup viewGroup, View view, int i) {
        return false;
    }


}
