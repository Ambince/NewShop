package com.example.amence_a.newshop.util;

import android.app.Activity;

import com.example.amence_a.newshop.activity.MainActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by Amence_A on 2016/7/31.
 */
public class SlidingUtil {
    /**
     * 切换侧边栏状态
     */
    public static void toggleSlidingMenu(Activity mActivity) {
        MainActivity mainUi = (MainActivity) mActivity;
        SlidingMenu slidingMenu = mainUi.getSlidingMenu();
        slidingMenu.toggle();

    }
}
