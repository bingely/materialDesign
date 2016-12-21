package com.bingley.materialdesign.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bingley.materialdesign.R;

import butterknife.Bind;

/**
 * $Description:定制化TitleView
 * Author:  Mr.bingley
 * Version:
 * Date:  2016/12/20
 */
public class TitleView extends RelativeLayout {
    /**
     * 上下文
     */
    protected Context context;
    /**
     * 父视图
     */
    protected View view_Parent;

    ImageView mIvLeft;
    TextView mTvMiddle;
    TextView mTvRight;
    ImageView mIvRight;

    public TitleView(Context context) {
        super(context);
        inflaterView(context);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflaterView(context);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflaterView(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void inflaterView(Context context) {
        this.context = context;
        view_Parent = LayoutInflater.from(context).inflate(R.layout.custom_toolbar_title, null);

        mIvLeft = (ImageView) view_Parent.findViewById(R.id.iv_left);
        mTvMiddle = (TextView) view_Parent.findViewById(R.id.tv_middle);
        mTvRight = (TextView) view_Parent.findViewById(R.id.tv_right);
        mIvRight = (ImageView) view_Parent.findViewById(R.id.iv_right);

        addView(view_Parent);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(CharSequence title) {
        mTvMiddle.setVisibility(View.VISIBLE);
        mTvMiddle.setText(title);
    }

    //默认设置左边按钮关闭页面
    public void setBackBtn() {
        mIvLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) context).finish();
            }
        });
    }


    //自定义左边按钮点击事件（可以设置相应的图片资源）
    public void setImgLeft(int resId, OnClickListener listener) {
        mIvLeft.setImageResource(resId);
        mIvLeft.setOnClickListener(listener);
    }



    /*//自定义左边按钮点击事件
    public void setImgLeft( OnClickListener listener){
        imgRightNew.setVisibility(View.VISIBLE);
        imgLeft.setOnClickListener(listener);
    }

    //自定义右边按钮点击事件
    public void setImgRight(int resId, OnClickListener listener){
        imgRightNew.setVisibility(View.VISIBLE);
        imgRightNew.setImageResource(resId);
        imgRightNew.setOnClickListener(listener);
    }

    //自定义左边按钮点击事件
    public void setRightText( String txt,OnClickListener listener){
        txtRight.setVisibility(View.VISIBLE);
        txtRight.setText(txt);
        txtRight.setOnClickListener(listener);
    }*/


    //活动分享  如下使用方式
   /* titleView.setImgRight(R.drawable.icon_share, new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    });*/
}
