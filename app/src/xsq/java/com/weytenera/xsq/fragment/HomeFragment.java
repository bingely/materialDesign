package com.weytenera.xsq.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.http.okhttp.OkHttpUtils;
import com.bingley.materialdesign.interf.OnTabReselectListener;
import com.bingley.materialdesign.utils.LogUtils;
import com.bingley.materialdesign.view.EmptyLayout;
import com.bingley.materialdesign.view.RecyclerRefreshLayout;
import com.weytenera.xsq.Urls;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/1/19.
 */
public class HomeFragment extends BaseFragment implements OnTabReselectListener {
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @Bind(R.id.refreshLayout)
    RecyclerRefreshLayout mRefreshLayout;
    @Bind(R.id.error_layout)
    EmptyLayout mErrorLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_base_recycler_view;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);


      OkHttpUtils.get(Urls.IMAGES_URL, new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                mErrorLayout.dismiss();
                
                LogUtils.e(response);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

    }

    @Override
    public void onTabReselect() {
        Toast.makeText(getActivity(), "homefragment", Toast.LENGTH_SHORT).show();
    }

}
