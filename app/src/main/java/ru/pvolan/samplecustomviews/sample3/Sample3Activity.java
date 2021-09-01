package ru.pvolan.samplecustomviews.sample3;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.pvolan.samplecustomviews.R;
import ru.pvolan.samplecustomviews.uikit.ballview.BallView;
import ru.pvolan.samplecustomviews.uikit.ballview.BallViewPostAnimator;
import ru.pvolan.samplecustomviews.uikit.ballview.BallViewSystemAnimator;
import ru.pvolan.samplecustomviews.uikit.ballview.BallViewThreadAnimator;
import ru.pvolan.samplecustomviews.uikit.ballview.BallViewThreadImprovedAnimator;
import ru.pvolan.samplecustomviews.uikit.vp_indicator.WormAnimator;
import ru.pvolan.samplecustomviews.uikit.vp_indicator.WormIndicatorView;

public class Sample3Activity extends AppCompatActivity {

    private BallView ballView1;
    private View touchLayout;


    private BallView ballView2;
    BallViewThreadAnimator ballViewThreadAnimator2;
    private BallView ballView3;
    BallViewPostAnimator ballViewThreadAnimator3;
    private BallView ballView4;
    BallViewSystemAnimator ballViewThreadAnimator4;
    private WormIndicatorView wormIndicatorView;
    WormAnimator wormAnimator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_3);

        //Touch sample
        ballView1 = findViewById(R.id.ballView1);
        touchLayout = findViewById(R.id.touchLayout);

        touchLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    int viewWidth = v.getWidth();
                    float actionX = event.getX();
                    float offset = actionX/viewWidth;
                    ballView1.setState(offset);
                }
                return true;
            }
        });


        //Animations
        ballView2 = findViewById(R.id.ballView2);
        ballView3 = findViewById(R.id.ballView3);
        ballView4 = findViewById(R.id.ballView4);
        wormIndicatorView = findViewById(R.id.wormIndicatorView);
        ballViewThreadAnimator2 = new BallViewThreadAnimator(ballView2, 16);
        ballViewThreadAnimator3 = new BallViewPostAnimator(ballView3, 16);
        ballViewThreadAnimator4 = new BallViewSystemAnimator(ballView4);
        wormAnimator = new WormAnimator(wormIndicatorView);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ballViewThreadAnimator2.start();
        ballViewThreadAnimator3.start();
        ballViewThreadAnimator4.start();
        wormAnimator.start();
    }

    @Override
    protected void onPause() {
        ballViewThreadAnimator2.stop();
        ballViewThreadAnimator3.stop();
        ballViewThreadAnimator4.stop();
        wormAnimator.stop();
        super.onPause();
    }
}