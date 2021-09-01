package ru.pvolan.samplecustomviews.uikit.ballview;

public class BallViewThreadAnimator {

    private BallView ballView;
    private boolean isRunning = false;
    private int timeFrame;

    public BallViewThreadAnimator(BallView ballView, int timeFrame) {
        this.ballView = ballView;
        this.timeFrame = timeFrame;
    }


    public void start(){
        Thread thread = new Thread(new AnimationRunnable());

        isRunning = true;
        thread.start();
    }


    public void stop(){
        isRunning = false;
    }


    private class AnimationRunnable implements Runnable {

        @Override
        public void run() {
            int duration = 10000;

            int framesCount = duration/timeFrame;

            for (int i = 0; i <= framesCount; i++) {

                if(!isRunning) return;

                try {
                    Thread.sleep(timeFrame);
                } catch (InterruptedException e) {

                }

                final float offset = (float)i/(float)framesCount;
                ballView.post(new Runnable() {
                    @Override
                    public void run() {
                        ballView.setState(offset);
                    }
                });
            }

            isRunning = false;
        }

    }
}
