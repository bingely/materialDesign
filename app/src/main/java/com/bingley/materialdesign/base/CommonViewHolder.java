package com.bingley.materialdesign.base;

import android.content.Context;
import android.text.Spanned;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingley.materialdesign.utils.StringUtils;


/**
 * 通用性极高的ViewHolder
 *
 */
public class CommonViewHolder {
    // 用于存储listView item的容器
    private SparseArray<View> mViews;

    // item根view
    private View mConvertView;

    protected Context mContext;

    private int position;

    public CommonViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mViews = new SparseArray<>();
        this.mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        this.mConvertView.setTag(this);
        this.mContext = context;
        this.position = position;
    }

    /**
     * 获取一个viewHolder
     *
     * @param context     context
     * @param convertView view
     * @param parent      parent view
     * @param layoutId    布局资源id
     * @param position    索引
     * @return
     */
    public static CommonViewHolder getViewHolder(Context context, View convertView, ViewGroup parent,
                                                 int layoutId, int position) {
        if (convertView == null) {
            return new CommonViewHolder(context, parent, layoutId, position);
        }

        return (CommonViewHolder) convertView.getTag();
    }

    public int getPosition() {
        return this.position;
    }

    // 通过一个viewId来获取一个view
    public <T extends View> T getView(int viewId) {

        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    // 返回viewHolder的容器类
    public View getConvertView() {
        return this.mConvertView;
    }

    // 给TextView设置文字
    public void setText(int viewId, String text) {
        if (StringUtils.isEmpty(text)) return;
        TextView tv = getView(viewId);
        tv.setText(text);
    }

    // 给TextView设置文字
    public void setText(int viewId, Spanned text) {
        if (text == null) return;
        TextView tv = getView(viewId);
        tv.setText(text);
    }

    // 给TextView设置文字
    public void setText(int viewId, int textRes) {
        TextView tv = getView(viewId);
        tv.setText(textRes);
    }

    public void setText(int viewId, String text, int emptyRes) {
        TextView tv = getView(viewId);
        if (StringUtils.isEmpty(text)) {
            tv.setText(emptyRes);
        } else {
            tv.setText(text);
        }
    }

    public void setText(int viewId, String text, String emptyText) {
        TextView tv = getView(viewId);
        if (StringUtils.isEmpty(text)) {
            tv.setText(emptyText);
        } else {
            tv.setText(text);
        }
    }


    // 给ImageView设置图片资源
    public void setImageResource(int viewId, int resId) {
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
    }

    /**
     * 向ImageView加载网络图片，否则显示默认图片
     * @param viewId  ImageView id
     * @param imgUrl  图片路径
     */
    public void setImageForUrl(int viewId, String imgUrl) {
        // 后续如果有需求的话，再加入该部分逻辑

        ImageView iv = getView(viewId);
        // 这里得为imageView加入tag,不然会报java.lang.IllegalArgumentException: You must not call setTag() on a view Glide is targeting
//        if (iv.getTag(R.id.glide_tag) == null || !iv.getTag(R.id.glide_tag).equals(imgUrl)) {
//            // 设置默认的图片
//            iv.setImageResource(R.drawable.loadfail);
//        }
       // GlideUtils.setImage(mContext, imgUrl, iv);
//        iv.setTag(R.id.glide_tag, imgUrl);
    }

    /**
     * 向ImageView加载圆形图片，否则显示默认图片
     * @param viewId  ImageView id
     * @param imgUrl  图片路径
     */
    public void setCircleImageForUrl(int viewId, String imgUrl) {

        ImageView iv = getView(viewId);
        // 这里得为imageView加入tag,不然会报java.lang.IllegalArgumentException: You must not call setTag() on a view Glide is targeting
//        if (iv.getTag(R.id.glide_tag) == null || !iv.getTag(R.id.glide_tag).equals(imgUrl)) {
//            // 设置默认的图片
//            iv.setImageResource(R.drawable.loadfail);
//        }
        //GlideUtils.setCircleImage(mContext, imgUrl, iv);
//        iv.setTag(R.id.glide_tag,imgUrl);
    }
}
