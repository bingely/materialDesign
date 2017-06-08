package com.bingley.materialdesign.topic.stock.kdemo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import zhangliang.view.android.klibrary.entity.MarketChartData;
import zhangliang.view.android.klibrary.view.KView;

public class KDiagramActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTexthight, mTextPrice, mTextLow, mTextVol, mTextRate;
    private ImageView mImageView;
    private KView mMyChartsView;
    private String currencyType, currencyType_dw, exchangeType = "CNY";
    private String kChartTimeInterval = "900";                       //图表数据间隔
    private final String kChartDataSize = "1440";                          //图表数据总条数
    private Double lastPrice, price = 0.0;
    private ImageView mChangeScreen;
    //定时器
    Timer timer1 = null;  //刷新定时器
    Timer timer2 = null;  //刷新定时器
    private final int dataRefreshTime1 = 4 * 1000;                         //数据刷新间隔
    private final int dataRefreshTime2 = 60 * 1000;                         //数据刷新间隔
    String type = "chbtcbtccny";
    private LinearLayout title_lay;
    private RadioGroup myRadioGroup;
    private HorizontalScrollView mHorizontalScrollView;// 上面的水平滚动控件
    private List<Map<String, Object>> titleList = new ArrayList<Map<String, Object>>();
    private Context mContext;
    private Button spinerButton;
    private boolean islandscape = false;
    List<String> list = new ArrayList<String>();
    private List<MarketChartData> marketChartDataLists = new ArrayList<MarketChartData>();
    //private SpinerPopWindow mSpinerPopWindow;
    private ArrayList data_list;
    private Resources res;
    private ArrayList symbol_str;
    private int ConfigurationType = Configuration.ORIENTATION_PORTRAIT;

    @Override
    protected int getContentView() {
        return R.layout.activity_kdiagram;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mContext = this;
        res = this.getResources();

        mMyChartsView = (KView) findViewById(R.id.my_charts_view);
        mImageView = (ImageView) findViewById(R.id.image);
        spinerButton = (Button) findViewById(R.id.spinerButton);
        spinerButton.setOnClickListener(this);

        title_lay = (LinearLayout) findViewById(R.id.title_lay);
        mHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);


        initGroup();
    }


    private void initGroup() {
        // 初始化时间选择的数据
        initTimeIndex();
        // 接下来是在一个容器里面放入多个RadioGroup

        // 先定义出RadioGroup出来
        myRadioGroup = new RadioGroup(mContext);
        myRadioGroup.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        myRadioGroup.setOrientation(LinearLayout.HORIZONTAL);
        title_lay.addView(myRadioGroup);

        for (int i = 0;i <titleList.size();i++) {
            Map<String, Object> map1 = titleList.get(i);
            RadioButton radio = new RadioButton(mContext);
            radio.setButtonDrawable(R.color.kViewblack);
            LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER);
            radio.setLayoutParams(l);
            radio.setGravity(Gravity.CENTER);
            radio.setPadding(20, 20, 20, 20);
            radio.setId(1 + i);
            radio.setText(map1.get("title") + "");

            // 为啥是等于2呢？？
            if (i == 2) {
                radio.setTextColor(getResources().getColor(R.color.subject_select));
                radio.setChecked(true);
               // radio.setBackground(getResources().getDrawable(R.drawable.bg_bottom));
            } else {
                radio.setTextColor(getResources().getColor(R.color.kViewztblack));
                radio.setChecked(false);
                radio.setBackground(null);
            }

            radio.setTag(map1);
            myRadioGroup.addView(radio);
        }
    }

    private void initTimeIndex() {
        // 这个就相当于自己伪造json
        // 一个集合里面存放的是Map元素
        Map<String, Object> map = new HashMap<>();
        map = new HashMap<String, Object>();
        map.put("id", "1");
        map.put("title", res.getString(R.string.one_min));
        map.put("time", 1 * 60 + "");
        titleList.add(map);
        map = new HashMap<String, Object>();
        map.put("id", "2");
        map.put("title", res.getString(R.string.five_min));
        map.put("time", 5 * 60 + "");
        titleList.add(map);
        map = new HashMap<String, Object>();
        map.put("id", "3");
        map.put("title", res.getString(R.string.fifteen_min));
        map.put("time", 15 * 60 + "");
        titleList.add(map);
        map = new HashMap<String, Object>();
        map.put("id", "4");
        map.put("title", res.getString(R.string.thirty_min));
        map.put("time", 30 * 60 + "");
        titleList.add(map);
        map = new HashMap<String, Object>();
        map.put("id", "5");
        map.put("title", res.getString(R.string.one_hour));
        map.put("time", 60 * 60 + "");
        titleList.add(map);
        map = new HashMap<String, Object>();
        map.put("id", "6");
        map.put("title", res.getString(R.string.two_hour));
        map.put("time", 2 * 60 * 60 + "");
        titleList.add(map);
        map = new HashMap<String, Object>();
        map.put("id", "7");
        map.put("title", res.getString(R.string.four_hour));
        map.put("time", 4 * 60 * 60 + "");
        titleList.add(map);
        map = new HashMap<String, Object>();
        map.put("id", "8");
        map.put("title", res.getString(R.string.six_hour));
        map.put("time", 6 * 60 * 60 + "");
        titleList.add(map);
        map = new HashMap<String, Object>();
        map.put("id", "9");
        map.put("title", res.getString(R.string.twelve_hour));
        map.put("time", 12 * 60 * 60 + "");
        titleList.add(map);
        map = new HashMap<String, Object>();
        map.put("id", "10");
        map.put("title", res.getString(R.string.one_day));
        map.put("time", 24 * 60 * 60 + "");
        titleList.add(map);
        map = new HashMap<String, Object>();
        map.put("id", "11");
        map.put("title", res.getString(R.string.three_day));
        map.put("time", 3 * 24 * 60 * 60 + "");
        titleList.add(map);
        map = new HashMap<String, Object>();
        map.put("id", "12");
        map.put("title", res.getString(R.string.one_week));
        map.put("time", 7 * 24 * 60 * 60 + "");
        titleList.add(map);
    }

    @Override
    public void onClick(View v) {

    }
}
