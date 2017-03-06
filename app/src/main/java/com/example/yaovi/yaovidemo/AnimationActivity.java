package com.example.yaovi.yaovidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends BaseActivity {
    private Animation alphaAnimation;
    private Animation rotateAnimation;
    private Animation scaleAnimation;
    private Animation transAnimation;
    private Animation setAnimation;


    @BindView(R.id.anim_tv)
    TextView tv;

    @OnClick(R.id.anim_alpha)
    public void alpha(){
        tv.startAnimation(alphaAnimation);
    }
    @OnClick(R.id.anim_scale)
    public void scale(){
        tv.startAnimation(scaleAnimation);
    }
    @OnClick(R.id.anim_rotate)
    public void rotate(){
        tv.startAnimation(rotateAnimation);
    }
    @OnClick(R.id.anim_trans)
    public void trans(){
        tv.startAnimation(transAnimation);
    }
    @OnClick(R.id.anim_set)
    public void set(){
        tv.startAnimation(setAnimation);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        initialAnimation();
    }

    private void initialAnimation() {
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        transAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_trans);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
    }


}
