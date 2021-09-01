package ru.pvolan.samplecustomviews.uikit.ballview;

import android.animation.ValueAnimator;
import android.util.Log;

public class BallViewSystemAnimator {


    private BallView ballView;
    private ValueAnimator animator;

    private final int duration = 10000;

    public BallViewSystemAnimator(BallView ballView) {
        this.ballView = ballView;
        animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(duration);
        animator.addUpdateListener(updateListener);
        animator.setInterpolator(null);

    }

    private final ValueAnimator.AnimatorUpdateListener updateListener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            float offset = (float) animation.getAnimatedValue();
            Log.i("BZZZ", "onAnimationUpdate " + offset);
            ballView.setState(offset);
        }
    };


    public void start(){
        animator.start();
    }


    public void stop(){
        animator.cancel();
    }

}
