package com.bingley.materialdesign.mvp.osc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseActivity;
import com.bingley.materialdesign.mvp.osc.fragment.FindFragment;
import com.bingley.materialdesign.mvp.osc.fragment.GeneralViewPagerFragment;
import com.bingley.materialdesign.mvp.osc.fragment.TweenFragment;
import com.bingley.materialdesign.mvp.osc.fragment.UserFragment;
import com.bingley.materialdesign.view.TabButton;

import butterknife.Bind;

/**
 * 我想实现点击下面某个模块会刷新界面功能
 * 当点击某个按钮的时候，直接回到首页
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/22
 */

public class OscMainActivity extends BaseActivity {


    @Bind(R.id.home_homePageTab)
    TabButton mHomeHomePageTab;
    @Bind(R.id.home_newsTab)
    TabButton mHomeNewsTab;
    @Bind(R.id.home_findTab)
    TabButton mHomeFindTab;
    @Bind(R.id.home_userTab)
    TabButton mHomeUserTab;
    @Bind(R.id.home_tabGroup)
    RadioGroup mHomeTabGroup;
    @Bind(R.id.main_content)
    FrameLayout mMainContent;
    private GeneralViewPagerFragment homeFragment;
    private TweenFragment tweenFragment;
    private FindFragment findFragment;
    private UserFragment userFragment;

    @Override
    protected int getContentView() {
        return R.layout.activity_oscmain;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        homeFragment = GeneralViewPagerFragment.newInstance();
        tweenFragment = TweenFragment.newInstance();
        findFragment = FindFragment.newInstance();
        userFragment = UserFragment.newInstance();

        mHomeTabGroup.setOnCheckedChangeListener(onTabCheckedChangeListener);
        mHomeHomePageTab.setOnClickListener(onTabClicklistener);
        mHomeNewsTab.setOnClickListener(onTabClicklistener);
        mHomeFindTab.setOnClickListener(onTabClicklistener);
        mHomeUserTab.setOnClickListener(onTabClicklistener);
        // 设置它为小红点
        mHomeUserTab.setShowTag(true);
        addFragment(getSupportFragmentManager(), homeFragment);

        // 模拟
       // System.out.println(1 / 0);

    }

    private void addFragment(FragmentManager fm, Fragment fragment) {
        if (!fragment.isAdded()) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.main_content, fragment);
            ft.commit();
        }
    }


    private void hideAllFragment(FragmentManager fm) {
        FragmentTransaction ft = fm.beginTransaction();
        if (!homeFragment.isHidden()) {
            ft.hide(homeFragment);
        }
        if (!tweenFragment.isHidden()) {
            ft.hide(tweenFragment);
        }
        if (!findFragment.isHidden()) {
            ft.hide(findFragment);
        }
        if (!userFragment.isHidden()) {
            ft.hide(userFragment);
        }
        ft.commit();
    }

    private void showFragment(FragmentManager fm, Fragment fragment) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragment);
        ft.commit();
    }


    private View.OnClickListener onTabClicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.home_homePageTab:
                    if (homeFragment.isAdded() && !homeFragment.isHidden()) {
                       // homeFragment.onTabClick((TabButton) v);
                    }
                    break;

                case R.id.home_newsTab:
                    if (tweenFragment.isAdded() && !tweenFragment.isHidden()) {
                        //newsFragment.onTabClick((TabButton) v);
                    }
                    break;

                case R.id.home_findTab:
                    if (findFragment.isAdded() && !findFragment.isHidden()) {
                       // findFragment.onTabClick((TabButton) v);
                    }
                    break;

                case R.id.home_userTab:
                    if (userFragment.isAdded() && !userFragment.isHidden()) {
                      //  userFragment.onTabClick((TabButton) v);
                    }
                    break;
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener onTabCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            FragmentManager fm = getSupportFragmentManager();
            hideAllFragment(fm);
            switch (checkedId) {
                case R.id.home_homePageTab:
                    showFragment(fm, homeFragment);
                    break;

                case R.id.home_newsTab:
                    addFragment(fm, tweenFragment);
                    showFragment(fm, tweenFragment);
                    break;

                case R.id.home_findTab:
                    addFragment(fm, findFragment);
                    showFragment(fm, findFragment);
                    break;

                case R.id.home_userTab:
                    addFragment(fm, userFragment);
                    showFragment(fm, userFragment);
                    break;
            }
        }
    };
}
