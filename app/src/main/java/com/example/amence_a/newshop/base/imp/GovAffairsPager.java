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
public class GovAffairsPager extends BasePager {
    public GovAffairsPager(Activity activity) {
        super(activity);
    }

    public void initData(){
        Log.v("Amence","政务");
        mTextView.setText("人口管理");
        setSlidingMenuEnable(true);
        TextView text = new TextView(mActivity);
        text.setText("政务");
        text.setTextColor(Color.RED);
        text.setTextSize(25);
        text.setGravity(Gravity.CENTER);
        mFrameLayout.addView(text);

    }
}
