package com.bingley.materialdesign.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.utils.LogUtils;
import com.bingley.materialdesign.topic.zhifeiji.mvp.homepager.DouBanFragment;
import com.bingley.materialdesign.topic.zhifeiji.mvp.homepager.ZhihuDailyFragment;
import com.bingley.materialdesign.topic.zhifeiji.mvp.homepager.ZhihuDailyPresenter;


public class MainFragment extends BaseFragment {

    private ZhihuDailyFragment zhihuDailyFragment;
    private DouBanFragment doubanMomentFragment;

    public static MainFragment newInstance() {
        MainFragment pageFragment = new MainFragment();
        return pageFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }


    /**
     * 按照标准的流程确实需要这两个流程，防止fragment"复活"
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            zhihuDailyFragment = (ZhihuDailyFragment) childFragmentManager.getFragment(savedInstanceState, "zhihu");
            doubanMomentFragment = (DouBanFragment) childFragmentManager.getFragment(savedInstanceState, "douban");
        } else {
            zhihuDailyFragment = ZhihuDailyFragment.newInstance();
            doubanMomentFragment = DouBanFragment.newInstance();
        }
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) root.findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(3);

        viewPager.setAdapter(new MainPagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        // 这个方法很重要，可以用来tablayout刷新逻辑
       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               if (0 == tab.getPosition()) {
                   LogUtils.e("刷新0");
               } else if (1 == tab.getPosition()) {
                   LogUtils.e("刷新1");
               }
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });


        // 接下来就是填充数据的操作了
        ZhihuDailyPresenter zhihuDailyPresenter = new ZhihuDailyPresenter();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FragmentManager manager = getChildFragmentManager();
        manager.putFragment(outState, "zhihu", zhihuDailyFragment);
        manager.putFragment(outState, "douban", doubanMomentFragment);
    }


    class MainPagerAdapter extends FragmentPagerAdapter {
        private String[] titles;

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);

            titles = new String[]{
                    "知乎日报", "豆瓣时刻"
            };
        }

        @Override
        public Fragment getItem(int position) {
            if (1 == position) {
                return doubanMomentFragment;
            }
            return zhihuDailyFragment;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        /**
         * 还得重写这个用来显示标题的写法
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

    }
}

