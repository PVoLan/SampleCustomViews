package ru.pvolan.samplecustomviews.uikit.ballview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class BallView extends View {

    public BallView(Context context) {
        super(context);
        init();
    }

    public BallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private float currentOffset;
    private String currentOffsetText;

    private float circleRadius;

    private Paint circlePaint;
    private TextPaint textPaint;
    private Paint debugPaint;

    private void init(){

        float dp = getContext().getResources().getDisplayMetrics().density;

        circlePaint = new Paint();
        circlePaint.setColor(0xff555599);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);

        textPaint = new TextPaint();
        textPaint.setColor(0xff555599);
        textPaint.setTextSize(16*dp);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);

        debugPaint = new Paint();
        debugPaint.setColor(0xffff0000);
        debugPaint.setStyle(Paint.Style.FILL);
        debugPaint.setAntiAlias(true);

        circleRadius = 10*dp;

        setState(0);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float w = getWidth();
        float h = getHeight();

        float cy = h/2;

        float circleDiameter = 2 * circleRadius;
        float usefulWidth = w - circleDiameter;

        float cx = circleRadius + usefulWidth * currentOffset;

        canvas.drawCircle(cx, cy, circleRadius, circlePaint);

        canvas.drawText(currentOffsetText, 10, h/2+60, textPaint);
    }



    public void setState(float currentOffset){
        Log.i("BZZZ", "setState " + currentOffset);
        this.currentOffset = currentOffset;
        currentOffsetText = Float.toString(currentOffset);
        invalidate();
    }
}
