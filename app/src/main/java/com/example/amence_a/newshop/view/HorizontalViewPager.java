package com.example.amence_a.newshop.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Amence_A on 2016/7/31.
 */
public class HorizontalViewPager extends ViewPager {
    public HorizontalViewPager(Context context) {
        super(context);
    }

    public HorizontalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 本控件自己处理事件，不会让父控件捕获
     *
     * @param ev
     * @return
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentItem() != 0) {
            getParent().requestDisallowInterceptTouchEvent(true);

        } else {
            getParent().requestDisallowInterceptTouchEvent(false);

        }
        return super.dispatchTouchEvent(ev);
    }
}
