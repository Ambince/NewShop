package com.example.amence_a.newshop.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.amence_a.newshop.R;
import com.example.amence_a.newshop.activity.MainActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by Amence_A on 2016/7/27.
 * 主页面ViewPager中显示的内容
 */
public class BasePager {
    public Activity mActivity;
    public TextView mTextView;
    public FrameLayout mFrameLayout;
    public View mRootView;
    public ImageButton imageButton;

    public BasePager(Activity activity) {
        this.mActivity = activity;
        initView();
    }

    public void initData() {
    }

    private void initView() {
        mRootView = View.inflate(mActivity, R.layout.base_pager, null);
        mTextView = (TextView) mRootView.findViewById(R.id.tv_title);
        mFrameLayout = (FrameLayout) mRootView.findViewById(R.id.fl_content);
        imageButton = (ImageButton) mRootView.findViewById(R.id.btn_menu);
    }

    public void setSlidingMenuEnable(boolean enable) {
        MainActivity mainUi = (MainActivity) mActivity;
        SlidingMenu slidingMenu = mainUi.getSlidingMenu();
        if (enable) {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        } else {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }

    }
}
