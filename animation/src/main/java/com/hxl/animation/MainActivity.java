package com.hxl.animation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import java.nio.charset.MalformedInputException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button frameAnimation;
    private Button tweenAnimation;
    private Button proptertyAnimaton;
    private ImageView pinkView;
    private ImageView blueView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        initView();

    }
    private void initView(){
        frameAnimation = (Button) findViewById(R.id.frame_animation);
        tweenAnimation = (Button) findViewById(R.id.tween_animation);
        proptertyAnimaton = (Button) findViewById(R.id.propterty_animation);
        pinkView = (ImageView) findViewById(R.id.pink_view);
        blueView = (ImageView) findViewById(R.id.blue_view);


        frameAnimation.setOnClickListener(this);
        tweenAnimation.setOnClickListener(this);
        proptertyAnimaton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frame_animation:

                Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.explode);

                //退出时使用
                getWindow().setExitTransition(transition);
                //第一次进入时使用
                getWindow().setEnterTransition(transition);
                //再次进入时使用
                getWindow().setReenterTransition(transition);
                Intent intent = new Intent(MainActivity.this,FrameActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.tween_animation:
                Intent intent1 = new Intent(MainActivity.this,TweenActivity.class);
                startActivity(intent1, ActivityOptions.makeSceneTransitionAnimation(this,pinkView,"light_pink").toBundle());
                break;
            case R.id.propterty_animation:

                Pair first = new Pair<>(pinkView, ViewCompat.getTransitionName(pinkView));

                Pair second = new Pair<>(blueView, ViewCompat.getTransitionName(blueView));
                ActivityOptionsCompat transitionActivityOptions =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(this, first, second);
                Intent intent2 = new Intent(MainActivity.this,ProptertyActivity.class);
                startActivity(intent2, transitionActivityOptions.toBundle());
                break;
        }
    }
}
