package com.bingley.materialdesign.mvp.osc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseActivity;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.mvp.osc.fragment.GeneralViewPagerFragment;
import com.bingley.materialdesign.mvp.osc.fragment.MeFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我想实现点击下面某个模块会刷新界面功能
 * 当点击某个按钮的时候，直接回到首页
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/22
 */

public class OscMainActivity extends BaseActivity {
    @Bind(R.id.iv_home)
    ImageView mIvHome;
    @Bind(R.id.iv_goods)
    ImageView mIvGoods;
    @Bind(R.id.iv_friend_circle)
    ImageView mIvFriendCircle;
    @Bind(R.id.iv_me)
    ImageView mIvMe;
    @Bind(R.id.ll_tab_goods)
    LinearLayout ll_tab_goods;//优品
    public
    @Bind(R.id.ll_tab_me)
    LinearLayout ll_tab_me;//我

    Fragment mContent;
    BaseFragment mBaseFragment;

    MeFragment meFragment;       // 我

    @Override
    protected int getContentView() {
        return R.layout.activity_common_tab_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mContent = new Fragment();
        mBaseFragment = new GeneralViewPagerFragment();
        mIvHome.setBackgroundResource(R.drawable.home_press);
        switchContent(mContent, mBaseFragment);
    }

    @OnClick({R.id.ll_tab_home, R.id.ll_tab_goods, R.id.ll_tab_add, R.id.ll_tab_circle, R.id.ll_tab_me})
    public void onclick(View view) {

        //hideFragment();
        int id = view.getId();
        if (id != R.id.ll_tab_add) {
            reSetTab();
        }
        switch (id) {
            case R.id.ll_tab_home:  // 首页
                if (mBaseFragment == null) {
                    mBaseFragment = new GeneralViewPagerFragment();
                }
                mIvHome.setBackgroundResource(R.drawable.home_press);
                switchContent(mContent, mBaseFragment);

               /* if (mBaseFragment != null
                        && mBaseFragment instanceof OnTabReselectListener) {
                    OnTabReselectListener listener = (OnTabReselectListener) mBaseFragment;
                    listener.onTabReselect();
                }*/
                break;
            case R.id.ll_tab_goods:  // 优品
                if (mBaseFragment == null) {
                    mBaseFragment = new GeneralViewPagerFragment();
                }
                mIvGoods.setBackgroundResource(R.drawable.goods_press);
                switchContent(mContent, mBaseFragment);
                break;
            case R.id.ll_tab_add:

                break;
            case R.id.ll_tab_circle:  // 圈子
                if (mBaseFragment == null) {
                    mBaseFragment = new GeneralViewPagerFragment();
                }

                mIvFriendCircle.setBackgroundResource(R.drawable.friend_circle_press);
                switchContent(mContent, mBaseFragment);
                break;
            case R.id.ll_tab_me:   // 我
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("gone", false);
                    meFragment.setArguments(bundle);
                }
                mIvMe.setBackgroundResource(R.drawable.me_press);
                switchContent(mContent, meFragment);
                break;
        }

        // 如果是把逻辑写在这边，fragment方式得重新写正确
        /*if (mBaseFragment != null
                && mBaseFragment instanceof OnTabReselectListener) {
            OnTabReselectListener listener = (OnTabReselectListener) mBaseFragment;
            listener.onTabReselect();
        }*/

    }

    public void switchContent(Fragment from, Fragment to) {
        if (mContent != to) {
            mContent = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(from).add(R.id.lin_main, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }

    private void reSetTab() {
        mIvHome.setBackgroundResource(R.drawable.home);
        mIvGoods.setBackgroundResource(R.drawable.goods);
        mIvFriendCircle.setBackgroundResource(R.drawable.friend_circle);
        mIvMe.setBackgroundResource(R.drawable.me);
    }

}
