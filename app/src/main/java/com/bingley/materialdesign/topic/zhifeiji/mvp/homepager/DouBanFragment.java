package com.bingley.materialdesign.topic.zhifeiji.mvp.homepager;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.topic.zhifeiji.bean.ZhihuDailyNews;

import java.util.ArrayList;

/**
 * 豆瓣
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/3/9
 */

public class DouBanFragment extends BaseFragment implements ZhihuDailyContract.View {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refresh;
    private FloatingActionButton fab;
    private TabLayout tabLayout;

    public static DouBanFragment newInstance() {
        return new DouBanFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_recyler_list;
    }

    @Override
    public void initViews(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        refresh = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);
        refresh.setColorSchemeResources(R.color.colorPrimary);

        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setRippleColor(getResources().getColor(R.color.colorPrimaryDark));

        // 父布局没有tab_layout，为啥可以识别  TODO??  我觉得应该在父布局中去初始化
        tabLayout = (TabLayout) getActivity().findViewById(R.id.tab_layout);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showResults(ArrayList<ZhihuDailyNews.Question> list) {

    }

    @Override
    public void showPickDialog() {

    }

    @Override
    public void setPresenter(ZhihuDailyContract.Presenter presenter) {

    }


}
