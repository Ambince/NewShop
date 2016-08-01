package com.example.amence_a.newshop.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.amence_a.newshop.R;
import com.example.amence_a.newshop.base.BasePager;
import com.example.amence_a.newshop.base.imp.GovAffairsPager;
import com.example.amence_a.newshop.base.imp.HomePager;
import com.example.amence_a.newshop.base.imp.NewsCenterPager;
import com.example.amence_a.newshop.base.imp.SettingPager;
import com.example.amence_a.newshop.base.imp.SmartServicePager;

import java.util.ArrayList;

/**
 * Created by Amence_A on 2016/7/26.
 * 主页面显示 viewpager+radioGroup
 */
public class ContentFragment extends BaseFragment {
    private ViewPager mViewPager;
    private ArrayList<BasePager> basePagers;
    private RadioGroup mRadioGroup;


    @Override
    public View init() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_content);
        mViewPager.setOffscreenPageLimit(1);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.content_radioGroup);
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
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        mViewPager.setCurrentItem(0, false);// 去掉切换页面的动画
                        break;
                    case R.id.rb_news:
                        mViewPager.setCurrentItem(1, false);// 设置当前页面
                        break;
                    case R.id.rb_smart:
                        mViewPager.setCurrentItem(2, false);// 设置当前页面
                        break;
                    case R.id.rb_gov:
                        mViewPager.setCurrentItem(3, false);// 设置当前页面
                        break;
                    case R.id.rb_setting:
                        mViewPager.setCurrentItem(4, false);// 设置当前页面
                        break;
                }
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当页面选的时候在初始化数据防止数据白白加载
                basePagers.get(position).initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //强制自己加载第一次数据
        basePagers.get(0).initData();

    }

    /**
     * 获取新闻中心页面
     *
     * @return
     */
    public NewsCenterPager getNewsCenterPager() {
        return (NewsCenterPager) basePagers.get(1);
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
            container.addView(basePager.mRootView);
            return basePager.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
