package com.example.amence_a.newshop.base.imp;

import android.app.Activity;

import com.example.amence_a.newshop.base.BasePager;

/**
 * Created by Amence_A on 2016/7/27.
 */
public class GovAffairsPager extends BasePager {
    public GovAffairsPager(Activity activity) {
        super(activity);
    }

    public void initData(){
        mTextView.setText("人口管理");
    }
}
