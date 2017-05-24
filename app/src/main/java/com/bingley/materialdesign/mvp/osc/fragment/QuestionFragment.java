package com.bingley.materialdesign.mvp.osc.fragment;

import com.bingley.materialdesign.base.BaseGeneralListFragment;
import com.bingley.materialdesign.base.CommonAdapter;
import com.bingley.materialdesign.mvp.osc.bean.Question;

 /**
   * 
   * Author:  Mr.bingley
   * Version: 
   * Date:  2017/5/24
   */
public class QuestionFragment extends BaseGeneralListFragment<Question> {
    @Override
    protected CommonAdapter<Question> getListAdapter() {
        return null;
    }

    @Override
    public void onItemClick(int position, Question data) {

    }
}
