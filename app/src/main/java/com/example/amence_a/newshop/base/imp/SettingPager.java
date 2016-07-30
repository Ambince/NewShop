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
public class SettingPager extends BasePager {

    public SettingPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        Log.v("Amence","设置");

        imageButton.setVisibility(View.INVISIBLE);
        mTextView.setText("设置");
        setSlidingMenuEnable(false);
        TextView text = new TextView(mActivity);
        text.setText("设置");
        text.setTextColor(Color.RED);
        text.setTextSize(25);
        text.setGravity(Gravity.CENTER);
        mFrameLayout.addView(text);
    }
}
