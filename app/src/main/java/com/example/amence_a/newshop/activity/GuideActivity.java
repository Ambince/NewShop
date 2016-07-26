package com.example.amence_a.newshop.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.amence_a.newshop.R;
import com.example.amence_a.newshop.util.PrefUtil;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    private int[] mImageViews = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    private ViewPager mViewPager;
    private List<ImageView> imageViewList = new ArrayList<>();
    private LinearLayout mLinearLayoutPoint;
    private int positionWidth;
    private View mPointRed;
    private Button mStartBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.myViewPager);
        mLinearLayoutPoint = (LinearLayout) findViewById(R.id.ll_point_group);
        mPointRed = findViewById(R.id.view_red_point);
        mStartBut = (Button) findViewById(R.id.btn_start);
        mStartBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });
        //定义显示数据
        for (int i = 0; i < mImageViews.length; i++) {
            ImageView mImageView = new ImageView(this);
            mImageView.setImageResource(mImageViews[i]);
            imageViewList.add(mImageView);
        }
        //自定义小圆点
        for (int i = 0; i < mImageViews.length; i++) {
            View view = new View(this);
            view.setBackgroundResource(R.drawable.shape_point_gray);
            //设置小圆点的布局属性
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            if (i > 0) {
                params.leftMargin = 10;
            }
            view.setLayoutParams(params);
            mLinearLayoutPoint.addView(view);
        }

        //获取小圆点之间的间距，因为布局的绘制在onResume之后绘制，所以在此时拿不到他的宽高，利用监听绘制后的方法
        mLinearLayoutPoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //在这里结束监听
                mLinearLayoutPoint.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                //获取小圆点的布局属性
                positionWidth = mLinearLayoutPoint.getChildAt(1).getLeft() - mLinearLayoutPoint.getChildAt(0).getLeft();
                Log.v("Amence", "positionWidth:" + positionWidth);
            }
        });


        mViewPager.setAdapter(new MyViewPagerAdapter());
        mViewPager.setOnPageChangeListener(new MyViewPagerChangeListener());
    }


    class MyViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageViews.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViewList.get(position));

            return imageViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    class MyViewPagerChangeListener implements ViewPager.OnPageChangeListener {

        /**
         * @param position             此时的位置
         * @param positionOffset       移动的百分比
         * @param positionOffsetPixels 移动的像素值
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Log.v("Amence", "onPageScrolled");
            //设置小圆点的边距
            int len = (int) (positionWidth * positionOffset + position * positionWidth);
            Log.v("Amence", "len:" + len);

            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mPointRed.getLayoutParams();
            params.leftMargin = len;
            mPointRed.setLayoutParams(params);

        }

        @Override
        public void onPageSelected(int position) {
            PrefUtil.setBoolean(GuideActivity.this, "is_show_guide", false);
            //如果是最后一张则跳转主页面
            if (position == mImageViews.length - 1) {
                //使按钮可见
                mStartBut.setVisibility(View.VISIBLE);
            } else {
                mStartBut.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


}
