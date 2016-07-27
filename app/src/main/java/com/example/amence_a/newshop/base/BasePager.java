package com.example.amence_a.newshop.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.amence_a.newshop.R;

/**
 * Created by Amence_A on 2016/7/27.
 */
public class BasePager {
    public Activity mActivity;
    public TextView mTextView;
    public FrameLayout mFrameLayout;
    public View mRootView;


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
    }
}
