package com.example.amence_a.newshop.base.menudetail;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.amence_a.newshop.base.BaseMenuDetailPager;

/**
 * Created by Amence_A on 2016/7/30.
 */
public class InteractMenuDetailPager extends BaseMenuDetailPager {
    public InteractMenuDetailPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        TextView text = new TextView(mActivity);
        text.setText("菜单");
        text.setTextColor(Color.RED);
        text.setTextSize(25);
        text.setGravity(Gravity.CENTER);
        return text;
    }
}
