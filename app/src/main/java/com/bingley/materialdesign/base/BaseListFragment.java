package com.bingley.materialdesign.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.bingley.materialdesign.R;
import com.bingley.materialdesign.view.CBSwipeRefreshLayout;
import com.bingley.materialdesign.view.EmptyLayout;

import java.util.List;


/**
 * T as the base bean
 * Created by Mr.bingley
 * on 16-5-23.
 */
public abstract class BaseListFragment<T> extends BaseFragment implements
        SwipeRefreshLayout.OnRefreshListener,
        AdapterView.OnItemClickListener, AbsListView.OnScrollListener, View.OnClickListener {

    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_LOADING = 1;
    public static final int TYPE_NO_MORE = 2;
    public static final int TYPE_ERROR = 3;
    public static final int TYPE_NET_ERROR = 4;
    public static final String BUNDLE_KEY_CATALOG = "asdfa";
    protected ListView mListView;
    protected CBSwipeRefreshLayout mRefreshLayout;
    protected EmptyLayout mErrorLayout;
    protected CommonAdapter<T> mAdapter;    // TODO
    protected boolean mIsRefresh;
    private String mTime;
    public View mFooterView;
    private ProgressBar mFooterProgressBar;
    private TextView mFooterText;

    protected int mCurrentPage = 1;
    protected boolean isFrist = true;
    private List<T> datas = null;

    // 当前数据状态，如果是已经全部加载，则不再执行滚动到底部就加载的情况
    private int dataState = LISTVIEW_ACTION_NONE;
    // 没有状态
    public static final int LISTVIEW_ACTION_NONE = -1;
    // 初始化时，加载缓存状态
    public static final int LISTVIEW_ACTION_INIT = 1;
    // 刷新状态，显示toast
    public static final int LISTVIEW_ACTION_REFRESH = 2;
    // 下拉到底部时，获取下一页的状态
    public static final int LISTVIEW_ACTION_SCROLL = 3;

    // 当前加载状态
    private int mState = STATE_NONE;

    static final int STATE_NONE = -1;
    static final int STATE_LOADING = 0;
    static final int STATE_LOADED = 1;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pull_refresh_listview;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        mListView = (ListView) root.findViewById(R.id.listView);
        mRefreshLayout = (CBSwipeRefreshLayout) root.findViewById(R.id.superRefreshLayout);
        mRefreshLayout.setColorSchemeResources(
                R.color.swiperefresh_color1, R.color.swiperefresh_color2,
                R.color.swiperefresh_color3, R.color.swiperefresh_color4);
        mErrorLayout = (EmptyLayout) root.findViewById(R.id.error_layout);
        mFooterView = LayoutInflater.from(getContext()).inflate(R.layout.layout_list_view_footer, null);
        mFooterText = (TextView) mFooterView.findViewById(R.id.tv_footer);
        mFooterProgressBar = (ProgressBar) mFooterView.findViewById(R.id.pb_footer);

        mRefreshLayout.setOnRefreshListener(this);
        mErrorLayout.setOnLayoutClickListener(this);

        // 设置listview的各种监听
        setupListView();


    }


    @Override
    protected void initData() {
        mAdapter = getListAdapter();

        requestData();

    }

    protected void onfailed() {
        onRequestError(TYPE_NET_ERROR);  // 通过失败错误码取返回对应的错误请求类型 ,在这里失败是网络没加载好
        onRequestFinish();
    }

    /**
     * 初始化ListView
     */
    protected void setupListView() {
        mListView.setOnScrollListener(this);
        mListView.setOnItemClickListener(this);
        if (isNeedFooter()) {     // 控制尾部是否有相关的提示
            mListView.addFooterView(mFooterView);
        }
        mListView.setAdapter(mAdapter);
    }


    public void loadDataSuccess(List<T> datas) {
        if (datas == null) return;
        if (datas.size() < 10) {       // 设置每一页的展示的数量
            dataState = 2;
            setFooterType(TYPE_NO_MORE);
        }
        if (mCurrentPage == 1) {
            mAdapter.clear();
        }
        mAdapter.addItem(datas);
        if (isFrist) {
            mListView.setAdapter(mAdapter);
        }
        if (mAdapter.getDatas().size() > 0) {
            mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
            mRefreshLayout.setVisibility(View.VISIBLE);
        } else {
            mErrorLayout.setErrorType(EmptyLayout.NODATA);
        }
    }

    protected abstract CommonAdapter<T> getListAdapter();

    protected void onRequestError(int code) {
        setFooterType(TYPE_NET_ERROR);
        if (mAdapter.getDatas().size() == 0)
            mErrorLayout.setErrorType(EmptyLayout.NETWORK_ERROR);
    }

    protected void onRequestFinish() {
        onComplete();
    }


    @Override
    public void onRefresh() {
        mIsRefresh = true;
        mCurrentPage = 1;
        isFrist = true;
        dataState = LISTVIEW_ACTION_NONE;
        mState = STATE_NONE;
        requestData();
    }

    // 请求完数据之后
    protected void onComplete() {
        if (mRefreshLayout != null) {
            mRefreshLayout.setRefreshing(false);
            mRefreshLayout.setEnabled(true);
            mErrorLayout.setVisibility(View.GONE);
            //mIsRefresh = false;
        }
    }

    /**
     * request network data
     */
    protected void requestData() {
        setFooterType(TYPE_LOADING);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 点击了底部
        if (view == mFooterView) {
            return;
        }
        T data = mAdapter.getItem(position);
        if (data == null) return;
        onItemClick(position, data);
    }

    public abstract void onItemClick(int position, T data);


    protected void setFooterType(int type) {
        try {
            switch (type) {
                case TYPE_NORMAL:
                case TYPE_LOADING:
                    mFooterText.setText(getResources().getString(R.string.footer_type_loading));
                    mFooterProgressBar.setVisibility(View.VISIBLE);
                    break;
                case TYPE_NET_ERROR:
                    mFooterText.setText(getResources().getString(R.string.footer_type_net_error));
                    mFooterProgressBar.setVisibility(View.GONE);
                    break;
                case TYPE_ERROR:
                    mFooterText.setText(getResources().getString(R.string.footer_type_error));
                    mFooterProgressBar.setVisibility(View.GONE);
                    break;
                case TYPE_NO_MORE:
                    mFooterText.setVisibility(View.GONE);
                    mFooterText.setText(getResources().getString(R.string.footer_type_not_more));
                    mFooterProgressBar.setVisibility(View.GONE);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean isNeedFooter() {
        return true;
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int i) {
        if (mAdapter == null || mAdapter.getCount() == 0) {
            return;
        }
        // 数据已经全部加载，或数据为空时，或正在加载，不处理滚动事件 TODO
        if (dataState == 2
                || dataState == 1 || mState == STATE_LOADING
                ) {
            return;
        }

        // 判断是否滚动到底部
        boolean scrollEnd = false;
        try {
            if (view.getPositionForView(mFooterView) == view
                    .getLastVisiblePosition())
                scrollEnd = true;
        } catch (Exception e) {
            scrollEnd = false;
        }
        if (scrollEnd) {
            ++mCurrentPage;
            requestData();
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
    }

    @Override
    public void onClick(View view) {
        requestData();
    }
}
