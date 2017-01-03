package com.bingley.materialdesign.mvp.elmssearch;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;

/**
 * 这是两个Activity，看起来顺化的原因是使用了一种叫做共享元素的概念。
 * Android 5.0自带共享元素的实现，但是有一些缺点比如：不能改变大小， 不能兼容4.X
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/1/3
 */

public class ElmFrament extends BaseFragment {
    private TextView mSearchBGTxt;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_elm;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        mSearchBGTxt = (TextView) root.findViewById(R.id.tv_search_bg);

        mSearchBGTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 注意这里拿到的是在屏幕中的坐标(它的坐标是以左上角为基准吗）。
                // 所以在第二个Activity中，获取第二个元素的坐标也要用屏幕中的坐标。

                Intent intent = new Intent(getActivity(), ElemsSearchActivity.class);
                int location[] = new int[2];
                mSearchBGTxt.getLocationOnScreen(location);
                intent.putExtra("x", location[0]);
                intent.putExtra("y", location[1]);
                startActivity(intent);
                getActivity().overridePendingTransition(0, 0);
            }
        });
    }
}
