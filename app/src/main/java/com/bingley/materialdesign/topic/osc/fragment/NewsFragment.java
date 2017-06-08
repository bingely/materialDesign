package com.bingley.materialdesign.topic.osc.fragment;

import android.view.View;

import com.bingley.materialdesign.AppContext;
import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseGeneralListFragment;
import com.bingley.materialdesign.base.CommonAdapter;
import com.bingley.materialdesign.topic.osc.OSChinaApi;
import com.bingley.materialdesign.topic.osc.adapter.NewsAdapter;
import com.bingley.materialdesign.topic.osc.bean.Banner;
import com.bingley.materialdesign.topic.osc.bean.News;
import com.bingley.materialdesign.topic.osc.bean.PageBean;
import com.bingley.materialdesign.topic.osc.bean.ResultBean;
import com.bingley.materialdesign.utils.AppOperator;
import com.bingley.materialdesign.utils.CacheManager;
import com.bingley.materialdesign.utils.LogUtils;
import com.bingley.materialdesign.view.EmptyLayout;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.TextHttpResponseHandler;


import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
   *
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/5/24
   */
public class NewsFragment extends BaseGeneralListFragment<News>{
    protected TextHttpResponseHandler mHandler;

    public PageBean<News> mBean;

    protected String CACHE_NAME = getClass().getName();
    private NewsAdapter mNewsAdapter;

    private static final String NEWS_BANNER = "news_banner";
    private String mSystemTime;

    @Override
    protected CommonAdapter<News> getListAdapter() {
        mNewsAdapter = new NewsAdapter(getActivity(), R.layout.item_list_news);
        return mNewsAdapter;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        AppOperator.runOnThread(new Runnable() {
            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                final PageBean<Banner> pageBean = (PageBean<Banner>) CacheManager.readObject(getActivity(), NEWS_BANNER);
                if (pageBean != null && pageBean.getItems() != null) {
                    LogUtils.e(NEWS_BANNER,NEWS_BANNER+"缓存的数量:"+pageBean.getItems().size());
                }
                /*if (pageBean != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((NewsAdapter) mAdapter).setSystemTime(AppContext.get(NEWS_SYSTEM_TIME, null));
                            mHeaderView.initData(getImgLoader(), pageBean.getItems());
                        }
                    });
                }*/
            }
        });
        getBannerList();
    }

    @Override
    protected void requestData() {
        super.requestData();
        mHandler = new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                onRequestError(statusCode);
                onRequestFinish();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    LogUtils.e(NEWS_BANNER,"news:"+responseString);
                    ResultBean<PageBean<News>> resultBean = AppContext.createGson().fromJson(responseString, new TypeToken<ResultBean<PageBean<News>>>() {
                    }.getType());
                    if (resultBean != null && resultBean.isSuccess() && resultBean.getResult().getItems() != null) {
                        //setListData(resultBean);
                        loadDataSuccess(resultBean.getResult().getItems());


                        mBean.setItems(resultBean.getResult().getItems());
                        AppOperator.runOnThread(new Runnable() {
                            @Override
                            public void run() {
                                CacheManager.saveObject(getActivity(), mBean, CACHE_NAME);
                            }
                        });
                        isFrist = false;
                    } else {
                        setFooterType(TYPE_NO_MORE);
                    }
                    onRequestFinish();
                } catch (Exception e) {
                    e.printStackTrace();
                    onFailure(statusCode, headers, responseString, e);
                }
            }
        };

        AppOperator.runOnThread(new Runnable() {
            @Override
            public void run() {
                mBean = (PageBean<News>) CacheManager.readObject(getActivity(), CACHE_NAME);
                //if is the first loading
                if (mBean == null) {
                    mBean = new PageBean<>();
                    mBean.setItems(new ArrayList<News>());
                    //onRefresh();
                } else {
                    mRoot.post(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.addItem(mBean.getItems());
                            LogUtils.e(NEWS_BANNER,"news緩存的數量:"+mBean.getItems().size());
                            mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
                            mRefreshLayout.setVisibility(View.VISIBLE);
                           // onRefresh();


                        }
                    });
                }
                OSChinaApi.getNewsList(mIsRefresh ? mBean.getPrevPageToken() : mBean.getNextPageToken(), mHandler);
            }
        });



    }

    @Override
    public void onItemClick(int position, News data) {

    }


    private void getBannerList() {
        OSChinaApi.getBannerList(OSChinaApi.CATALOG_BANNER_NEWS, new TextHttpResponseHandler() {


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                LogUtils.e(NEWS_BANNER,responseString);
                try {
                    final ResultBean<PageBean<Banner>> resultBean = AppContext.createGson().fromJson(responseString, new TypeToken<ResultBean<PageBean<Banner>>>() {
                    }.getType());
                    mSystemTime = resultBean.getTime();
                    ((NewsAdapter) mAdapter).setSystemTime(mSystemTime);
                    if (resultBean != null && resultBean.isSuccess()) {
                        AppOperator.runOnThread(new Runnable() {
                            @Override
                            public void run() {
                                CacheManager.saveObject(getActivity(), resultBean.getResult(), NEWS_BANNER);
                            }
                        });
                       // mHeaderView.initData(getImgLoader(), resultBean.getResult().getItems());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
