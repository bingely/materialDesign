package com.example.bingpay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;

import com.example.bingpay.bean.MarketChartData;

import java.util.ArrayList;
import java.util.List;

/**
   *
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/4/21
   */

public class MyKView extends MyGridChartView{
    /**
     * 触摸点
     */
    private float mStartX;
    private float mStartY;

    /**
     * 默认Y轴字体颜色
     **/
    private static final int DEFAULT_AXIS_Y_TITLE_COLOR = Color.YELLOW;

    /**
     * 默认X轴字体颜色
     **/
    private static final int DEFAULT_AXIS_X_TITLE_COLOR = Color.RED;

    /**
     * 显示的OHLC数据起始位置
     */
    private int mDataStartIndext;

    /**
     * 显示的OHLC数据个数
     */
    private int mShowDataNum;
    private int showNum = 0;

    /**
     * 当前数据的最大最小值
     */
    private double mMaxPrice;
    private double mMinPrice;
    /**
     * 成交量最大值
     */
    private double mMaxVol;

    //记录最小值
    private int minIndex;
    //记录最大值
    private int maxIndex;

    private float olddistance = 0f;
    private float newdistance = 0f;
    private int count = 0;

    private boolean mShowMACD = false;
    private boolean mShowJKD = false;

    /**
     * 显示纬线数
     */
    private int latitudeNum = super.DEFAULT_UPER_LATITUDE_NUM;

    /**
     * 显示经线数
     */
    private int longtitudeNum = super.DEFAULT_LOGITUDE_NUM;

    /**
     * 显示的最小Candle数
     */
    private final static int MIN_CANDLE_NUM = 10;
    /**
     * 显示的最大Candle数
     */
    private final static int MAX_CANDLE_NUM = 480;

    /**
     * 默认显示的Candle数
     */
    private final static int DEFAULT_CANDLE_NUM = 240;

    /**
     * 最小可识别的移动距离
     */
    private final static int MIN_MOVE_DISTANCE = 55;

    /**
     * Candle宽度
     */
    private double mCandleWidth;

    /**
     * Candle间隔
     */
    private final static int CANDLE_MIN_DISTANCE = 2;
    /**
     * MA数据
     */
   // private List<MALineEntity> MALineData;
    /**
     * OHLC数据
     */
    private List<MarketChartData> mOHLCData = new ArrayList<MarketChartData>();


    /**
     * 默认五日均线颜色
     **/
    public static int kline5dayline = 0x535d66;
    /**
     * 默认十日均线颜色
     **/
    public static int kline10dayline = 0x535d66;
    /**
     * 默认30日均线颜色
     **/
    public static int kline30dayline = 0x535d66;

    public static int klineRed = 0xC80000;
    public static int klineGreen = 0x7AA376;

    /**
     * 量能均线数组
     */
    //private List<MALineEntity> MAVLineData;

    private Context mConext;
   // private MACD mMACDData;
   // private KDJ mKDJData;
    private Resources res;
    private MarketChartData topMarketInfo;



    public MyKView(Context context) {
        super(context);
    }

    public MyKView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOHLCData(List<MarketChartData> OHLCData) {
        //分时，小时切换，重置  mDataStartIndext
        mDataStartIndext = 0;
        if (OHLCData == null || OHLCData.size() <= 0) {
            return;
        }

        if (null != mOHLCData) {
            mOHLCData.clear();
        }
        for (MarketChartData e : OHLCData) {
            //addData(e);
        }

        //K线均线
       // initMALineData();
       // setCurrentData();
        postInvalidate();
    }
}
