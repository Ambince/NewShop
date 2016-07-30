package com.example.amence_a.newshop.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Amence_A on 2016/7/27.
 */
public class NoScrollViewPager extends ViewPager {
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 重写onTouchEvent事件,什么都不用做
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    /**
     * 事件不向下传递
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
