package com.bingley.materialdesign.mvp.materal.recyleandcard;

import com.bingley.materialdesign.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/1/18.
 */

public class RecyleAdapter2 extends BaseQuickAdapter<String> {

    public RecyleAdapter2(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.item_tv, s);

    }
}
