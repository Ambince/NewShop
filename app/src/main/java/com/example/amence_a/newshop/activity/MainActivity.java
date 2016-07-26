package com.example.amence_a.newshop.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.amence_a.newshop.R;
import com.example.amence_a.newshop.fragment.ContentFragment;
import com.example.amence_a.newshop.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
    public static final String FRAGMENT_MENU = "FRAGMENT_MENU";
    public static final String FRAGMENT_CONTENT = "FRAGMENT_CONTENT";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBehindContentView(R.layout.left_menu);// 设置侧边栏
        SlidingMenu slidingMenu = getSlidingMenu();// 获取侧边栏对象
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// 设置全屏触摸
        slidingMenu.setBehindOffset(200);// 设置预留屏幕的宽度
        stepFragment();
    }

    public void stepFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.rl_left_menu, new LeftMenuFragment(), FRAGMENT_MENU);
        transaction.replace(R.id.rl_fragment_content, new ContentFragment(), FRAGMENT_CONTENT);
        transaction.commit();

    }
}