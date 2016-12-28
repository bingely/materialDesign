package com.bingley.materialdesign.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingley.materialdesign.R;

/**
 * 自定义组合控件 item
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/28
 */

public class ComItemLayoutView extends FrameLayout {

    public ComItemLayoutView(Context context) {
        super(context);
    }

    public ComItemLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ViewGroup.LayoutParams lps = new ViewGroup.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        View viewRoot = LayoutInflater.from(context).inflate(R.layout.common_item_layout, null);
        TextView titleView = (TextView) viewRoot.findViewById(R.id.hint_title);
        ImageView iconImageView = (ImageView) viewRoot
                .findViewById(R.id.icon_img);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Comitem_attr);

        //图片
        if (typedArray.hasValue(R.styleable.Comitem_attr_cicon)) {
            int imgId = typedArray.getResourceId(R.styleable.Comitem_attr_cicon, R.mipmap.loading_default);
            iconImageView.setImageResource(imgId);
        }

        //标题
        if (typedArray.hasValue(R.styleable.Comitem_attr_ctitle)) {
            String titleStr = typedArray.getString(R.styleable.Comitem_attr_ctitle);
            titleView.setText(titleStr);
        }

        typedArray.recycle();

        viewRoot.setLayoutParams(lps);

        addView(viewRoot);
    }


}
