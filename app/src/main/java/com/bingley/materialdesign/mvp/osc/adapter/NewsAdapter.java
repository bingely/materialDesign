package com.bingley.materialdesign.mvp.osc.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;

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
    private String systemTime;

    public NewsAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(CommonViewHolder vh, News item) {
        vh.setText(R.id.tv_description, item.getBody());
        vh.setText(R.id.tv_time, StringUtils.friendly_time(item.getPubDate()));
        vh.setText(R.id.tv_comment_count, String.valueOf(item.getCommentCount()));

        TextView title = vh.getView(R.id.tv_title);
        if (StringUtils.isSameDay(systemTime, item.getPubDate())) {

            String text = "[icon] " + item.getTitle();
            Drawable drawable = mContext.getResources().getDrawable(R.drawable.ic_label_today);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);

            SpannableString spannable = new SpannableString(text);
            spannable.setSpan(imageSpan, 0, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            title.setText(spannable);
            title.setTextSize(16.0f);
        } else {
            title.setText(item.getTitle());
        }
    }

    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }
}
