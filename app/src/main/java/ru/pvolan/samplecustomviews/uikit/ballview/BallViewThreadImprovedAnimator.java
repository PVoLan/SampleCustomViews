package ru.pvolan.samplecustomviews.uikit.ballview;

public class BallViewThreadImprovedAnimator {

    private BallView ballView;
    private boolean isRunning = false;
    private int timeFrame;

    public BallViewThreadImprovedAnimator(BallView ballView, int timeFrame) {
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

            long startTime = System.currentTimeMillis();

            while (true) {

                if(!isRunning) return;

                try {
                    Thread.sleep(timeFrame);
                } catch (InterruptedException e) {

                }

                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime;

                final float offset;
                if(elapsedTime >= duration){
                    offset = 1;
                    isRunning = false;
                } else {
                    offset = (float)elapsedTime/(float)duration;
                }

                ballView.post(new Runnable() {
                    @Override
                    public void run() {
                        ballView.setState(offset);
                    }
                });
            }
        }

    }
}
