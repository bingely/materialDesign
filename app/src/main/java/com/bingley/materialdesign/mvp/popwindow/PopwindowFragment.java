package com.bingley.materialdesign.mvp.popwindow;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/21.
 */

public class PopwindowFragment extends BaseFragment {

    @Bind(R.id.showpop)
    Button mShowpop;
    private TopRightMenu mTopRightMenu;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_popwindow;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

    }

    @OnClick(R.id.showpop)
    public void onClick() {
        mTopRightMenu = new TopRightMenu(getActivity());
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(R.mipmap.multichat, "发起多人聊天"));
        menuItems.add(new MenuItem(R.mipmap.pay, "加好友"));
        menuItems.add(new MenuItem(R.mipmap.qr_scan, "扫一扫"));
        mTopRightMenu
                .setHeight(480)     //默认高度480
                .setWidth(320)      //默认宽度wrap_content
                .showIcon(true)     //显示菜单图标，默认为true
                .dimBackground(true)           //背景变暗，默认为true
                .needAnimationStyle(true)   //显示动画，默认为true
                .setAnimationStyle(R.style.TRM_ANIM_STYLE)  //默认为R.style.TRM_ANIM_STYLE
                .addMenuList(menuItems)
                .addMenuItem(new MenuItem(R.mipmap.multichat, "面对面快传"))
                .addMenuItem(new MenuItem(R.mipmap.pay, "付款"))
                .setOnMenuItemClickListener(new TopRightMenu.OnMenuItemClickListener() {
                    @Override
                    public void onMenuItemClick(int position) {
                        Toast.makeText(getActivity(), "点击菜单:" + position, Toast.LENGTH_SHORT).show();
                    }
                })
                .showAsDropDown(mShowpop, -155, 0);
    }
}
