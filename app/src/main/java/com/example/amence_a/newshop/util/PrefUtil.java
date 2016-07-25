package com.example.amence_a.newshop.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Amence_A on 2016/7/25.
 */
public class PrefUtil {
    private static final String PREF_NAME = "config";

    //获取sp的值
    public  static boolean getBoolean(Context ctx, String key) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, true);

    }

    //设置sp的值
    public static void setBoolean(Context context, String key, boolean is_guide_show) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key, is_guide_show).commit();

    }

}




