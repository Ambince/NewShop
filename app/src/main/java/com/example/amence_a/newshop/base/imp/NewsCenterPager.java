package com.example.amence_a.newshop.base.imp;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.example.amence_a.newshop.activity.MainActivity;
import com.example.amence_a.newshop.base.BaseMenuDetailPager;
import com.example.amence_a.newshop.base.BasePager;
import com.example.amence_a.newshop.base.menudetail.InteractMenuDetailPager;
import com.example.amence_a.newshop.base.menudetail.NewsMenuDetailPager;
import com.example.amence_a.newshop.base.menudetail.PhotoMenuDetailPager;
import com.example.amence_a.newshop.base.menudetail.TopicMenuDetailPager;
import com.example.amence_a.newshop.fragment.LeftMenuFragment;
import com.example.amence_a.newshop.global.GlobalContants;
import com.example.amence_a.newshop.to.NewsData;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;

/**
 * Created by Amence_A on 2016/7/27.
 */
public class NewsCenterPager extends BasePager {

    private ArrayList<BaseMenuDetailPager> mPagers;
    private NewsData mNewsData;

    public NewsCenterPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        getDataFromServer();
        setSlidingMenuEnable(true);
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
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        parseData(responseInfo.result);
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {

                    }

                });










    }

    private void parseData(String result) {
        Gson gson = new Gson();
        mNewsData = gson.fromJson(result, NewsData.class);
        //刷新获取侧边栏数据
        MainActivity mainUi = (MainActivity) mActivity;
        LeftMenuFragment leftMenuFragment = mainUi.getLeftMenuFragment();
        leftMenuFragment.setMenuData(mNewsData);

        //准备4个菜单详情页
        mPagers = new ArrayList<>();
        mPagers.add(new NewsMenuDetailPager(mActivity,mNewsData.data.get(0).children));
        mPagers.add(new TopicMenuDetailPager(mActivity));
        mPagers.add(new PhotoMenuDetailPager(mActivity));
        mPagers.add(new InteractMenuDetailPager(mActivity));
        //设置菜单详情页-新闻为默认当前页
        setCurrentMenuDetailPager(0);


    }

    public void setCurrentMenuDetailPager(int position) {
        BaseMenuDetailPager pager = mPagers.get(position);
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(pager.mRootView);

        NewsData.NewsMenuData menuData = mNewsData.data.get(position);
        mTextView.setText(menuData.title);
        pager.initData();

    }


}
