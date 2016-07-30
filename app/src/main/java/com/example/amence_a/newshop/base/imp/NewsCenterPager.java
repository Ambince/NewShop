package com.example.amence_a.newshop.base.imp;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.example.amence_a.newshop.activity.MainActivity;
import com.example.amence_a.newshop.base.BasePager;
import com.example.amence_a.newshop.fragment.LeftMenuFragment;
import com.example.amence_a.newshop.global.GlobalContants;
import com.example.amence_a.newshop.to.NewsData;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by Amence_A on 2016/7/27.
 */
public class NewsCenterPager extends BasePager {

    private NewsData mNewsData;

    public NewsCenterPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        getDataFromServer();
        Log.v("Amence", "新闻");
        mTextView.setText("新闻中心");
        setSlidingMenuEnable(true);
        TextView text = new TextView(mActivity);
        text.setText("新闻");
        text.setTextColor(Color.RED);
        text.setTextSize(25);
        text.setGravity(Gravity.CENTER);
        mFrameLayout.addView(text);

    }

    /**
     * 从服务器获取数据
     */
    private void getDataFromServer() {
        String url = GlobalContants.CATEGORIES_URL;
        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET,
                url,
                new RequestCallBack<String>() {
                    @Override
                    public void onLoading(long total, long current, boolean isUploading) {
                        Log.v("Amence", "onLoading");

                    }

                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        parseData(responseInfo.result);
                        Log.v("Amence", "onSuccess" + responseInfo.result);
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        Log.v("Amence", "onFailure");


                    }

                    @Override
                    public void onStart() {
                        Log.v("Amence", "onStart");

                    }


                });
    }

    private void parseData(String result) {
        Gson gson = new Gson();
        mNewsData = gson.fromJson(result, NewsData.class);
        MainActivity mainUi = (MainActivity) mActivity;
        LeftMenuFragment leftMenuFragment = mainUi.getLeftMenuFragment();
        leftMenuFragment.setMenuData(mNewsData);

    }

}
