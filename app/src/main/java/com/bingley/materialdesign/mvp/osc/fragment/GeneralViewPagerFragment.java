package com.bingley.materialdesign.mvp.osc.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.adapter.ViewPageFragmentAdapter;
import com.bingley.materialdesign.base.BaseGeneralListFragment;
import com.bingley.materialdesign.base.BaseListFragment;
import com.bingley.materialdesign.base.BaseViewPagerFragment;
import com.bingley.materialdesign.interf.OnTabReselectListener;
import com.bingley.materialdesign.mvp.osc.bean.BlogList;
import com.bingley.materialdesign.mvp.osc.bean.NewsList;

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
        Fragment fragment = mTabsAdapter.getItem(mViewPager.getCurrentItem());
            if (fragment != null && fragment instanceof BaseGeneralListFragment) {
            ((BaseGeneralListFragment) fragment).onTabReselect();
        }
    }

    @Override
    protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
        String[] title = getResources().getStringArray(R.array.general_viewpage_arrays);
        adapter.addTab(title[0], "news", NewsFragment.class,
                getBundle(NewsList.CATALOG_ALL));
        adapter.addTab(title[1], "latest_blog", BlogFragment.class,
                getBundle(NewsList.CATALOG_WEEK));
        adapter.addTab(title[2], "question", QuestionFragment.class,
                getBundle(BlogList.CATALOG_LATEST));
        adapter.addTab(title[3], "activity", EventFragment.class,
                getBundle(BlogList.CATALOG_RECOMMEND));
    }

    private Bundle getBundle(int newType) {
        Bundle bundle = new Bundle();
        bundle.putInt(BaseListFragment.BUNDLE_KEY_CATALOG, newType);
        return bundle;
    }

    /**
     * 基类会根据不同的catalog展示相应的数据
     *
     * @param catalog 要显示的数据类别
     * @return
     */
    private Bundle getBundle(String catalog) {
        Bundle bundle = new Bundle();
        bundle.putString(BlogFragment.BUNDLE_BLOG_TYPE, catalog);
        return bundle;
    }


    @Override
    protected void setScreenPageLimit() {
        mViewPager.setOffscreenPageLimit(3);
    }

    /**
     * 返回fragment中一个实例
     * @return
     */
    public static GeneralViewPagerFragment newInstance() {
        Bundle args = new Bundle();
        GeneralViewPagerFragment fragment = new GeneralViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
