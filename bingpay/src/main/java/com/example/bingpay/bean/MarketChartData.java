package com.example.bingpay.bean;

import java.text.SimpleDateFormat;

 /**
   * 
   * Author:  Mr.bingley
   * Version: 
   * Date:  2017/4/21
   */
public class MarketChartData{


    long time = 0;  // 时间
    double openPrice = 0;  // 开盘价
    double closePrice = 0; // 收盘价
    double lowPrice = 0;   // 最高价
    double highPrice = 0;  // 最低价
    double vol = 0;

    public double zf;

    public MarketChartData() {

    }

    public long getTime() {
        return time;
    }

    public String getTime2() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(time*1000);
    }
    public String getTime3() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(time*1000);
    }
    public String getTime4() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        return sdf.format(time*1000);
    }
    public void setTime(long time) {
        this.time = time;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

}
