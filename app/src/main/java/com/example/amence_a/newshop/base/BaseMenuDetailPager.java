package com.example.amence_a.newshop.base;

import android.app.Activity;
import android.view.View;

/**
 * Created by Amence_A on 2016/7/30.
 */
public abstract class BaseMenuDetailPager {
    public Activity mActivity;
    public View mRootView;

    public BaseMenuDetailPager(Activity activity) {
        this.mActivity = activity;
        this.mRootView = initView();
    }

    public void initData() {

    }

    public abstract View initView();
}
