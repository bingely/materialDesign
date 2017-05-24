package com.bingley.materialdesign.mvp.osc.adapter;

import android.content.Context;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.CommonAdapter;
import com.bingley.materialdesign.base.CommonViewHolder;
import com.bingley.materialdesign.mvp.osc.bean.News;
import com.bingley.materialdesign.utils.StringUtils;

/**
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/5/24
 */

public class NewsAdapter extends CommonAdapter<News> {
    public NewsAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(CommonViewHolder vh, News item) {
        vh.setText(R.id.tv_description, item.getBody());
        vh.setText(R.id.tv_time, StringUtils.friendly_time(item.getPubDate()));
        vh.setText(R.id.tv_comment_count, String.valueOf(item.getCommentCount()));
    }
}
