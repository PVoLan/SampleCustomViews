package ru.pvolan.samplecustomviews.uikit.vp_indicator;

import android.animation.ValueAnimator;
import android.util.Log;

import ru.pvolan.samplecustomviews.uikit.ballview.BallView;

public class WormAnimator {


    private WormIndicatorView wormIndicatorView;
    private ValueAnimator animator;

    private final int duration = 10000;
    private final int wormsCount = 5;

    public WormAnimator(WormIndicatorView wormIndicatorView) {
        this.wormIndicatorView = wormIndicatorView;
        animator = ValueAnimator.ofFloat(0, wormsCount-1);
        animator.setDuration(duration);
        animator.addUpdateListener(updateListener);
        animator.setInterpolator(null);
        //animator.setRepeatCount(ValueAnimator.INFINITE);
        //animator.setRepeatMode(ValueAnimator.REVERSE);
    }

    private final ValueAnimator.AnimatorUpdateListener updateListener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            float offset = (float) animation.getAnimatedValue();

            int currentItemIndex = (int) offset;
            float currentItemOffset = offset - currentItemIndex;

            wormIndicatorView.setState(wormsCount, currentItemIndex, currentItemOffset);
        }
    };


    public void start(){
        animator.start();
    }


    public void stop(){
        animator.cancel();
    }

}
