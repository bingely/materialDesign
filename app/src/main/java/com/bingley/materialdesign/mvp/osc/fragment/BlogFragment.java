package com.bingley.materialdesign.mvp.osc.fragment;

import com.bingley.materialdesign.base.BaseGeneralListFragment;
import com.bingley.materialdesign.base.CommonAdapter;
import com.bingley.materialdesign.mvp.osc.bean.Blog;

/**
 * Created by SAM on 2017/5/24.
 */
public class BlogFragment extends BaseGeneralListFragment<Blog>{
    public static final String BUNDLE_BLOG_TYPE = "BUNDLE_BLOG_TYPE";

    @Override
    protected CommonAdapter<Blog> getListAdapter() {
        return null;
    }

    @Override
    public void onItemClick(int position, Blog data) {

    }
}
