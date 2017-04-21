package com.bingley.materialdesign.mvp.pullreflsh.bga;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.utils.ToastUtil;
import com.bingley.materialdesign.view.BGAFixedIndicator;

import butterknife.Bind;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
   * $Description:$
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/4/8
   */

public class ScrollViewFragment extends BaseFragment implements BGARefreshLayout.BGARefreshLayoutDelegate{
    @Bind(R.id.bga)
    BGARefreshLayout mRefreshLayout;

    @Bind(R.id.indicator)
    BGAFixedIndicator mIndicator;
    @Bind(R.id.vp_viewpager_content)
    ViewPager mViewPager;


    private Fragment[] mFragments;
    private String[] mTitles;
    private StickyNavRecyclerViewFragment mRecyclerViewFragment;
    private StickyNavRecyclerViewFragment mListViewFragment;
    private StickyNavRecyclerViewFragment mScrollViewFragment;
    private StickyNavRecyclerViewFragment mWebViewFragment;
    @Override
    protected int getLayoutId() {
        return R.layout.bga_scroll;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        // 为BGARefreshLayout 设置代理  (必选）
        mRefreshLayout.setDelegate(this);
        mRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(getActivity(), true));


        mFragments = new Fragment[4];
        mFragments[0] = mRecyclerViewFragment = new StickyNavRecyclerViewFragment();
        mFragments[1] = mListViewFragment = new StickyNavRecyclerViewFragment();
        mFragments[2] = mScrollViewFragment = new StickyNavRecyclerViewFragment();
        mFragments[3] = mWebViewFragment = new StickyNavRecyclerViewFragment();
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {
        ToastUtil.show("refreshing");
        // 如果网络可用，则加载网络数据
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
                // 加载完毕后在 UI 线程结束下拉刷新
                ToastUtil.show("end");
                mRefreshLayout.endRefreshing();
            }
        }.execute();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        return false;
    }
}
