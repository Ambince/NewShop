package com.example.amence_a.newshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.amence_a.newshop.R;
import com.example.amence_a.newshop.util.PrefUtil;

public class SplashActivity extends AppCompatActivity {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mImageView = (ImageView) findViewById(R.id.image_animation);
        startAnimation();
    }

    private void startAnimation() {
        //动画集合
        AnimationSet set = new AnimationSet(false);
        //旋转动画
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f);
        //动画保持时间
        rotate.setDuration(1000);
        //动画结束后保持状态
        rotate.setFillAfter(true);

        //缩放动画
        ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(1000);
        scale.setFillAfter(true);
        //渐变动画
        AlphaAnimation animation = new AlphaAnimation(0, 1);
        animation.setFillAfter(true);
        animation.setDuration(2000);
        set.addAnimation(rotate);
        set.addAnimation(scale);
        set.addAnimation(animation);

        //设置动画监听
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.v("Amence", "onAnimationStart");

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                showGuide();


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

                Log.v("Amence", "onAnimationRepeat");


            }
        });

        //给图片设置动画

        mImageView.setAnimation(set);


    }

    private void showGuide() {
        boolean isShowGuide = PrefUtil.getBoolean(SplashActivity.this, "is_show_guide");
        Log.v("Amence", "isShowGuide=" + isShowGuide);
        if (isShowGuide) {
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
            finish();
        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }

    }

}
