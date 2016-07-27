package com.example.amence_a.newshop.base.imp;

import android.app.Activity;

import com.example.amence_a.newshop.base.BasePager;

/**
 * Created by Amence_A on 2016/7/27.
 */
public class NewsCenterPager  extends BasePager{
    public NewsCenterPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        mTextView.setText("新闻中心");
    }

}
