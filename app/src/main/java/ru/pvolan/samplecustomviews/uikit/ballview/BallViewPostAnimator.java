package ru.pvolan.samplecustomviews.uikit.ballview;

public class BallViewPostAnimator {

    private BallView ballView;
    private boolean isRunning = false;

    private final int duration = 10000;
    private long startTime;
    private int timeFrame;

    public BallViewPostAnimator(BallView ballView, int timeFrame) {
        this.ballView = ballView;
        this.timeFrame = timeFrame;
    }


    public void start(){

        isRunning = true;
        startTime = System.currentTimeMillis();

        ballView.postDelayed(new PostRunnable(), timeFrame);
    }


    public void stop(){
        isRunning = false;
    }


    private class PostRunnable implements Runnable{

        @Override
        public void run() {

            if(!isRunning) return;

            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;

            final float offset;
            if(elapsedTime >= duration){
                offset = 1;
                isRunning = false;
            } else {
                offset = (float)elapsedTime/(float)duration;
            }

            ballView.setState(offset);

            ballView.postDelayed(this, timeFrame);
        }

    }

}
