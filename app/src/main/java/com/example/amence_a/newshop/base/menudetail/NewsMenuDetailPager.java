package com.example.amence_a.newshop.base.menudetail;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.amence_a.newshop.R;
import com.example.amence_a.newshop.activity.MainActivity;
import com.example.amence_a.newshop.base.BaseMenuDetailPager;
import com.example.amence_a.newshop.base.TabDetailPager;
import com.example.amence_a.newshop.to.NewsData;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;

/**
 * Created by Amence_A on 2016/7/30.
 */
public class NewsMenuDetailPager extends BaseMenuDetailPager {
    private SlidingMenu slidingMenu;

    private ViewPager viewPager;
    private ArrayList<TabDetailPager> mPagerList;
    private ArrayList<NewsData.NewsTabData> mNewsTabData;
    private TitlePageIndicator titleIndicator;
    private ImageButton mButNext;

    public NewsMenuDetailPager(Activity activity, ArrayList<NewsData.NewsTabData> children) {
        super(activity);
        mNewsTabData = children;

    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.news_menu_detail, null);
        viewPager = (ViewPager) view.findViewById(R.id.vp_menu_detail);
        titleIndicator = (TitlePageIndicator) view.findViewById(R.id.titles);
        mButNext = (ImageButton) view.findViewById(R.id.btn_next);
        titleIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                MainActivity mainUi = (MainActivity) mActivity;
                slidingMenu = mainUi.getSlidingMenu();
                if (position == 0) {

                    slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                } else {
                    slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;


    }

    @Override
    public void initData() {
        mPagerList = new ArrayList<>();
        for (int i = 0; i < mNewsTabData.size(); i++) {
            TabDetailPager pager = new TabDetailPager(mActivity, mNewsTabData.get(i));
            mPagerList.add(pager);

        }

        viewPager.setAdapter(new MenuDetailAdapter());
        titleIndicator.setViewPager(viewPager);
        mButNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = viewPager.getCurrentItem();
                viewPager.setCurrentItem(++currentPosition);
            }
        });


    }

    class MenuDetailAdapter extends PagerAdapter {
        @Override
        public CharSequence getPageTitle(int position) {
            return mNewsTabData.get(position).title;
        }

        @Override
        public int getCount() {
            return mPagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TabDetailPager tabDetailPager = mPagerList.get(position);
            container.addView(tabDetailPager.mRootView);
            tabDetailPager.initData();
            return tabDetailPager.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
