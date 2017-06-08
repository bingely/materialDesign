package com.bingley.materialdesign.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseActivity;
import com.bingley.materialdesign.fragment.MaterialListFragment;
import com.bingley.materialdesign.topic.pullreflsh.bga.ScrollViewFragment;
import com.bingley.materialdesign.topic.socket.MySocketFragment;
import com.bingley.materialdesign.topic.aidldemo.MAIDLFragment;
import com.bingley.materialdesign.topic.anim.AnimFragment;
import com.bingley.materialdesign.topic.customview.CustomViewFragment;
import com.bingley.materialdesign.topic.dialog.DialogFragment;
import com.bingley.materialdesign.topic.elmssearch.ElmFrament;
import com.bingley.materialdesign.topic.stock.KFragment;
import com.bingley.materialdesign.topic.stock.MinuntFragment;
import com.bingley.materialdesign.topic.lunbo.LunboFragment;
import com.bingley.materialdesign.topic.materal.ElevationFragment;
import com.bingley.materialdesign.topic.materal.palette.PaletteActivity;
import com.bingley.materialdesign.topic.materal.recyleandcard.RecycleListFragment;
import com.bingley.materialdesign.topic.materal.SvgFragment;
import com.bingley.materialdesign.topic.materal.TintingFragment;
import com.bingley.materialdesign.topic.popwindow.PopwindowFragment;
import com.bingley.materialdesign.topic.scrolldemo.ScrollFragment;
import com.bingley.materialdesign.topic.sqlite.SqliteFragment;
import com.bingley.materialdesign.topic.stock.StockFragment;
import com.bingley.materialdesign.topic.textview.TextViewFragment;
import com.bingley.materialdesign.view.TitleView;

import butterknife.Bind;

/**
 * 实现Google+滑动显示、隐藏toolbar
 * 我觉得应该一种容器的作用，放置的是各个fragment
 */
public class KnowleageDetailActivty extends BaseActivity {
    @Bind(R.id.titleview)
    TitleView mTitleview;
    @Bind(R.id.fl_container)
    FrameLayout mFrameLayout;

    @Override
    protected int getContentView() {
        return R.layout.act_container;
    }


    public static void gotoActivity(Context context, int code) {
        context.startActivity(new Intent(context, KnowleageDetailActivty.class).putExtra("material", code));
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mTitleview.setBackBtn();
        int material = getIntent().getIntExtra("material", 0);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (material) {
            case 1:
                mTitleview.setTitle("5.0新特性");
                MaterialListFragment collectFragment = new MaterialListFragment();
                fragmentTransaction.add(R.id.fl_container, collectFragment);
                break;
            case 1001:
                mTitleview.setTitle("5.0新特性");
                startActivity(new Intent(this, PaletteActivity.class));
                break;
            case 2:
                mTitleview.setTitle("下拉刷新");
                ScrollViewFragment jdFragment = new ScrollViewFragment();
                fragmentTransaction.add(R.id.fl_container, jdFragment);
                break;
            case 3:
                mTitleview.setTitle("TextVIew Demo");
                TextViewFragment textViewFragment = new TextViewFragment();
                fragmentTransaction.add(R.id.fl_container, textViewFragment);
                break;

            case 4:
                mTitleview.setTitle("Dialog Demo");
                DialogFragment dialogFragment = new DialogFragment();
                fragmentTransaction.add(R.id.fl_container, dialogFragment);
                break;
            case 5:
                mTitleview.setTitle("popwindow Demo");
                PopwindowFragment popwindowFragment = new PopwindowFragment();
                fragmentTransaction.add(R.id.fl_container, popwindowFragment);
                break;
            case 6:
                mTitleview.setTitle("elm Demo");
                ElmFrament elmFrament = new ElmFrament();
                fragmentTransaction.add(R.id.fl_container, elmFrament);
                break;
            case 7:
                mTitleview.setTitle("anim Demo");
                AnimFragment animFragment = new AnimFragment();
                fragmentTransaction.add(R.id.fl_container, animFragment);
                break;
            case 8:
                mTitleview.setTitle("轮播图 Demo");
                LunboFragment lunboFragment = new LunboFragment();
                fragmentTransaction.add(R.id.fl_container, lunboFragment);
                break;
            case 9:
                mTitleview.setTitle("数据库 Demo");
                SqliteFragment sqliteFragment = new SqliteFragment();
                fragmentTransaction.add(R.id.fl_container, sqliteFragment);
                break;

            case 10:
                mTitleview.setTitle("自定义 Demo");
                CustomViewFragment customViewFragment = new CustomViewFragment();
                fragmentTransaction.add(R.id.fl_container, customViewFragment);
                break;
            case 12:
                mTitleview.setTitle("scrollFragment Demo");
                ScrollFragment scrollFragment = new ScrollFragment();
                fragmentTransaction.add(R.id.fl_container, scrollFragment);
                break;
            case 13:
                mTitleview.setTitle("aidl Demo");
                MAIDLFragment maidlFragment = new MAIDLFragment();
                fragmentTransaction.add(R.id.fl_container, maidlFragment);
                break;
            case 14:


                mTitleview.setTitle("股票 Demo");
                StockFragment stockFragment = new StockFragment();
                fragmentTransaction.add(R.id.fl_container, stockFragment);
                break;
            case 15:
                setOrLANDSCAPE();
                mTitleview.setTitle("Demo");
                MinuntFragment minuntFragment = new MinuntFragment();
                //TimesFragment minuntFragment = new TimesFragment();
                fragmentTransaction.add(R.id.fl_container, minuntFragment);
                break;
            case 16:
                //setOrLANDSCAPE();
                mTitleview.setTitle("Demo");
                 KFragment kFragment = new KFragment();
                //KChartsFragment kFragment = new KChartsFragment();
               // CombinedChartFragment kFragment = new CombinedChartFragment();
                fragmentTransaction.add(R.id.fl_container, kFragment);
                break;

            case 17:
                //setOrLANDSCAPE();
                mTitleview.setTitle("Demo");
                MySocketFragment mySocketFragment = new MySocketFragment();
                fragmentTransaction.add(R.id.fl_container, mySocketFragment);
                break;

            case 1000:
                mTitleview.setTitle("svg Demo");
                SvgFragment svgFragment = new SvgFragment();
                fragmentTransaction.add(R.id.fl_container, svgFragment);
                break;

            case 1002:
                mTitleview.setTitle("elevation Demo");
                ElevationFragment elevationFragment = new ElevationFragment();
                fragmentTransaction.add(R.id.fl_container, elevationFragment);
                break;

            case 1003:
                mTitleview.setTitle("tint Demo");
                TintingFragment tintingFragment = new TintingFragment();
                fragmentTransaction.add(R.id.fl_container, tintingFragment);
                break;

            case 1004:
                mTitleview.setTitle("tint Demo");
                RecycleListFragment recycleListFragment = new RecycleListFragment();
                fragmentTransaction.add(R.id.fl_container, recycleListFragment);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }


    public void setOrLANDSCAPE() {
        /**
         * 设置为横屏
         */
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }



}
