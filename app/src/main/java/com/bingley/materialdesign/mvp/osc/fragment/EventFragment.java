package com.bingley.materialdesign.mvp.osc.fragment;

import com.bingley.materialdesign.base.BaseGeneralListFragment;
import com.bingley.materialdesign.base.CommonAdapter;
import com.bingley.materialdesign.mvp.osc.bean.Event;

 /**
   *
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/5/24
   */
public class EventFragment extends BaseGeneralListFragment<Event> {
    @Override
    protected CommonAdapter<Event> getListAdapter() {
        return null;
    }

    @Override
    public void onItemClick(int position, Event data) {

    }
}
