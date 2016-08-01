package com.example.amence_a.newshop.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Amence_A on 2016/7/31.
 */
public class TopicMenuViewPager extends ViewPager {

    private int startX;
    private int startY;

    public TopicMenuViewPager(Context context) {
        super(context);
    }

    public TopicMenuViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 本控件自己处理事件，不会让父控件捕获
     * 1.右滑到第一个的时候不能拦截2.左滑到最后一个的时候不能拦截3上下滑动的时候不能拦截
     *
     * @param ev
     * @return
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //点击的时候需要拦截
                getParent().requestDisallowInterceptTouchEvent(false);
                //求此时的宽高
                startX = (int) ev.getRawX();
                startY = (int) ev.getRawY();

                break;
            case MotionEvent.ACTION_MOVE:

                int endX = (int) ev.getRawX();
                int endY = (int) ev.getRawY();
                //判断是否为上下滑动
                if(Math.abs(endY-startY)>Math.abs(endX-startX)){
                    //此时为上下滑动不能拦截
                    getParent().requestDisallowInterceptTouchEvent(false);

                }else {
                    if(endX>startX){//右滑
                        if(getCurrentItem()==0){
                            getParent().requestDisallowInterceptTouchEvent(false);

                        }
                    }else {
                        if(getCurrentItem()==getAdapter().getCount()-1){
                            getParent().requestDisallowInterceptTouchEvent(false);

                        }
                    }

                }


                break;
        }


        return super.dispatchTouchEvent(ev);
    }
}
