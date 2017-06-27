package com.hxl.animation;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by hp_laptop on 2017/5/27.
 */
public class TweenActivity extends AppCompatActivity{
    private ImageView tweenImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween_activity);
        initView();
    }
    private void initView(){
        tweenImage = (ImageView) findViewById(R.id.tween_image);

        Animation alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.alpha);
        tweenImage.startAnimation(alphaAnimation);

    }
}
