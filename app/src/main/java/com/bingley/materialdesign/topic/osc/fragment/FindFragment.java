package com.bingley.materialdesign.topic.osc.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.topic.leftrightscrollview.MyLeftAdapter;
import com.bingley.materialdesign.topic.leftrightscrollview.MyRightAdapter;
import com.bingley.materialdesign.topic.leftrightscrollview.RightModel;
import com.bingley.materialdesign.topic.leftrightscrollview.SyncHorizontalScrollView;
import com.bingley.materialdesign.utils.ListViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAM on 2017/5/27.
 */
public class FindFragment extends BaseFragment{
    private LinearLayout leftContainerView;
    private ListView leftListView;
    private List<String> leftlList;
    private LinearLayout rightContainerView;
    private ListView rightListView;
    private List<RightModel> models;
    private SyncHorizontalScrollView titleHorsv;
    private SyncHorizontalScrollView contentHorsv;

    @Override
    protected int getLayoutId() {
        // frg_databind
        return R.layout.layout_tab_view;
    }
    public static FindFragment newInstance() {
        Bundle args = new Bundle();
        FindFragment fragment = new FindFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        // 如果是在fragment中 databinding如何写

       /* ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("loonggg", "23");
        binding.setUser(user);*/


        leftContainerView = (LinearLayout) root.findViewById(R.id.left_container);
        leftListView = (ListView) root.findViewById(R.id.left_container_listview);
        rightContainerView = (LinearLayout) root.findViewById(R.id.right_container);
        rightListView = (ListView) root.findViewById(R.id.right_container_listview);
        titleHorsv = (SyncHorizontalScrollView) root.findViewById(R.id.title_horsv);
        contentHorsv = (SyncHorizontalScrollView) root.findViewById(R.id.content_horsv);
        // 设置两个水平控件的联动
        titleHorsv.setScrollView(contentHorsv);
        contentHorsv.setScrollView(titleHorsv);

        // 添加左边内容数据
        //leftContainerView.setBackgroundColor(Color.YELLOW);
        initLeftData();
        MyLeftAdapter adapter=new MyLeftAdapter(getActivity(), leftlList);
        leftListView.setAdapter(adapter);
        ListViewUtils.setListViewHeightBasedOnChildren(leftListView);
        // 添加右边内容数据
        // rightContainerView.setBackgroundColor(Color.GRAY);
        initRightData();
        MyRightAdapter myRightAdapter=new MyRightAdapter(getActivity(), models);
        rightListView.setAdapter(myRightAdapter);
        ListViewUtils.setListViewHeightBasedOnChildren(rightListView);

    }

    private void initRightData() {
        models=new ArrayList<RightModel>();
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
    }

    private void initLeftData() {
        leftlList=new ArrayList<String>();
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
    }

}
