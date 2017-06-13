package com.bingley.materialdesign.topic.achartview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.bingley.materialdesign.topic.achartview.bean.CrossBean;
import com.bingley.materialdesign.topic.achartview.utils.ColorUtil;

/**
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/6/12
 */
// 处理事件
public class CrossView extends View {
    //手势控制
    private GestureDetector gestureDetector;
    private OnMoveListener onMoveListener;

    private CrossBean bean;

    public CrossView(Context context, AttributeSet attrs) {
        super(context, attrs);

        gestureDetector = new GestureDetector(getContext(),new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                //单击隐藏十字线
                setVisibility(GONE);
                if (onMoveListener != null) {
                    onMoveListener.onDismiss();
                }
                return super.onSingleTapUp(e);
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                //滑动时，通知到接口
                if (onMoveListener != null) {
                    onMoveListener.onCrossMove(e2.getX(), e2.getY());
                }
                return super.onScroll(e1, e2, distanceX, distanceY);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(event);
        }
        return true;// 代表自己处理这个touchevent事件
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 开始画十字线
        drawCrossLine(canvas);
    }

    private void drawCrossLine(Canvas canvas) {
        //当该点没有数据的时候，不画
        if (bean.x < 0 || bean.y < 0) return;
        boolean isJunXian = bean.y2 >= 0;
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(ColorUtil.COLOR_CROSS_LINE);
    }

    /**
     * 十字线移动的监听
     */
    public interface OnMoveListener {
        /**
         * 十字线移动(回调到数据存放的位置，判断是否需要画线后，再调用本界面画线方法)
         *
         * @param x x轴坐标
         * @param y y轴坐标
         */
        void onCrossMove(float x, float y);

        /**
         * 十字线消失的回调
         */
        void onDismiss();
    }
}
