package com.bingley.materialdesign.mvp.lunbo;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bingley.materialdesign.R;

import java.util.ArrayList;
import java.util.List;

/**
   * 轮播图
   * Author:  Mr.bingley
   * Version:
   * Date:  2016/12/28
   */


/**
 * 图片轮播

   指示器

   图片指示器联动

   定时轮播
 */

public class CycleRotationView extends FrameLayout{

    private Context mContext;
    private ViewPager mViewPager;
    private LinearLayout mPointGroup;

    private List<ImageView> mList; // 资源集合
    private Handler mHandler;

    private int pointSize = 20; // 小圆点的大小，默认为20dp
    private int pointMargin = 20; // 与前面一个小圆点的距离，默认为20dp


    public CycleRotationView(Context context) {
        super(context);
    }

    public CycleRotationView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.mContext = context;
        mHandler = new Handler();
        mList = new ArrayList();
        initView(mContext);
    }

    /**
     * 初始化布局
     * @param mContext
     */
    private void initView(Context mContext) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.cycle_rotation_layout, this, true);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mPointGroup = (LinearLayout) view.findViewById(R.id.pointGroup);
    }

    /**
     * 设置图片的url
     * @param urls 图片的url
     */
    public void setUrls(String[] urls) {
        if (urls == null || urls.length == 0) {
            setVisibility(GONE);
            return;
        }
    }
}
