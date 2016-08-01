package com.example.amence_a.newshop.base;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.amence_a.newshop.R;
import com.example.amence_a.newshop.global.GlobalContants;
import com.example.amence_a.newshop.to.NewsData;
import com.example.amence_a.newshop.to.TabData;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by Amence_A on 2016/7/30.
 */
public class TabDetailPager extends BaseMenuDetailPager {
    private NewsData.NewsTabData TabData;
    private View view;
    private ViewPager mViewPager;
    private String mUrl;
    private TabData tabData;
    private TopicMenuDetail topicMenuDetail;

    public TabDetailPager(Activity activity, NewsData.NewsTabData newsTabData) {
        super(activity);
        this.TabData = newsTabData;
        mUrl = GlobalContants.SEVER_URL + TabData.url;

    }

    @Override
    public View initView() {
        view = View.inflate(mActivity, R.layout.tab_detail_pager, null);
        mViewPager = (ViewPager) view.findViewById(R.id.tab_detail_pager);
        return view;
    }

    @Override
    public void initData() {
        getDataFromServer();
    }

    /**
     * 从服务器解析数据
     */
    private void getDataFromServer() {
        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET,
                mUrl,
                new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        Log.v("Amence", "responseInfo.result" + responseInfo.result);
                        parseData(responseInfo.result);
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {

                    }

                });


    }

    private void parseData(String result) {
        Gson gson = new Gson();
        tabData = gson.fromJson(result, TabData.class);
        topicMenuDetail = new TopicMenuDetail();
        mViewPager.setAdapter(topicMenuDetail);

    }

    /**
     * ViewPager适配器
     */
    class TopicMenuDetail extends PagerAdapter {

        private final BitmapUtils utils;

        public TopicMenuDetail() {
            utils = new BitmapUtils(mActivity);
            utils.configDefaultLoadingImage(R.drawable.topnews_item_default);// 设置默认图片
        }

        @Override
        public int getCount() {
            return tabData.data.topnews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(mActivity);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);//基于控件大小填充图片
            TabData.TopNewsData data = tabData.data.topnews.get(position);
            Log.v("Amence", "data=" + data.topimage);
            utils.display(imageView, data.topimage);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
