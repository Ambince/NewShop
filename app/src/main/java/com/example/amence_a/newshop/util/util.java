package com.example.amence_a.newshop.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/8/11 0011.
 */
public class util {


    public static int dp2px(int dp, Context ctx) {
        //获取设备密度
        DisplayMetrics displayMetrics = ctx.getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        return (int) (dp * density + 0.5f);

    }

    public static int px2dp(int px, Context ctx) {
        DisplayMetrics displayMetrics = ctx.getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        return (int) (px / density + 0.5f);
    }

    public static int getSystemWidth(Context ctx){
        WindowManager windowManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        return windowManager.getDefaultDisplay().getWidth();
    }

    public static int getSystemHeight(Context ctx){
        WindowManager windowManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        return windowManager.getDefaultDisplay().getHeight();
    }

}
