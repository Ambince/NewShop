package com.example.amence_a.newshop.base.imp;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.example.amence_a.newshop.base.BasePager;

/**
 * Created by Amence_A on 2016/7/27.
 */
public class SmartServicePager extends BasePager {
    public SmartServicePager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        mTextView.setText("智慧服务");
        setSlidingMenuEnable(true);
        TextView text = new TextView(mActivity);
        text.setText("智慧服务");
        text.setTextColor(Color.RED);
        text.setTextSize(25);
        text.setGravity(Gravity.CENTER);
        mFrameLayout.addView(text);
    }
}
