package com.bingley.materialdesign.mvp.osc.fragment;

import android.view.View;
import android.widget.Toast;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.adapter.ViewPageFragmentAdapter;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.base.BaseViewPagerFragment;
import com.bingley.materialdesign.interf.OnTabReselectListener;

 /**
   * 综合Tab界面
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/5/22
   */
public class GeneralViewPagerFragment extends BaseViewPagerFragment implements OnTabReselectListener {

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

    }

    @Override
    public void onTabReselect() {
        Toast.makeText(getActivity(), "homefragment", Toast.LENGTH_SHORT).show();
    }

     @Override
     protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
        // getResources().getStringArray()
     }
 }
