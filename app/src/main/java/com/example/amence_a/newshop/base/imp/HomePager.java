package com.example.amence_a.newshop.base.imp;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.amence_a.newshop.base.BasePager;

/**
 * Created by Amence_A on 2016/7/27.
 */
public class HomePager extends BasePager {
    public HomePager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        setSlidingMenuEnable(false);
        imageButton.setVisibility(View.GONE);
        mTextView.setText("主页");
        TextView text = new TextView(mActivity);
        text.setText("主页");
        text.setTextColor(Color.RED);
        text.setTextSize(25);
        text.setGravity(Gravity.CENTER);
        mFrameLayout.addView(text);
    }
}
