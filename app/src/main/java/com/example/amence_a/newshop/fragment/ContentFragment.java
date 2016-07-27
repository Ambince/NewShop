package com.example.amence_a.newshop.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.amence_a.newshop.R;
import com.example.amence_a.newshop.base.BasePager;
import com.example.amence_a.newshop.base.imp.GovAffairsPager;
import com.example.amence_a.newshop.base.imp.HomePager;
import com.example.amence_a.newshop.base.imp.NewsCenterPager;
import com.example.amence_a.newshop.base.imp.SettingPager;
import com.example.amence_a.newshop.base.imp.SmartServicePager;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by Amence_A on 2016/7/26.
 */
public class ContentFragment extends BaseFragment {
    private ViewPager mViewPager;
    private ArrayList<BasePager> basePagers;


    @Override
    public View init() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_content);
        return view;
    }

    public void initData() {

        basePagers = new ArrayList<BasePager>();
        basePagers.add(new HomePager(mActivity));
        basePagers.add(new NewsCenterPager(mActivity));
        basePagers.add(new SmartServicePager(mActivity));
        basePagers.add(new GovAffairsPager(mActivity));
        basePagers.add(new SettingPager(mActivity));


        mViewPager.setAdapter(new ContentAdapter());


    }

    class ContentAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager basePager = basePagers.get(position);
            basePager.initData();
            container.addView(basePager.mRootView);
            return basePager.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
