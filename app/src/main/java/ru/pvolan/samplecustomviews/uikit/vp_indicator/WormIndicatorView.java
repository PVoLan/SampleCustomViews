package ru.pvolan.samplecustomviews.uikit.vp_indicator;

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

public class WormIndicatorView extends View {

    public WormIndicatorView(Context context) {
        super(context);
        init();
    }

    public WormIndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WormIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WormIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private int itemCount;
    private int currentItemIndex;
    private float currentOffset;

    private float circleRadius;
    private float circlePadding;
    private float circleEnlargement;

    private Paint circlePaint;
    private Paint debugPaint;

    private RectF tempRect = new RectF();

    private void init(){

        float dp = getContext().getResources().getDisplayMetrics().density;

        circlePaint = new Paint();
        circlePaint.setColor(0xff555599);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);

        debugPaint = new Paint();
        debugPaint.setColor(0xffff0000);
        debugPaint.setStyle(Paint.Style.FILL);
        debugPaint.setAntiAlias(true);

        circleRadius = 10*dp;
        circlePadding = 10*dp;
        circleEnlargement = 30*dp;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(itemCount == 0) return;

        float w = getWidth();
        float h = getHeight();

        float cx = w/2;
        float cy = h/2;

        float circleDiameter = 2 * circleRadius;

        float totalWidth = itemCount * circleDiameter
                + (itemCount - 1) * circlePadding
                + circleEnlargement;

        float totalHeight = circleDiameter;

        float totalX = cx - (totalWidth / 2);
        float totalY = cy - (totalHeight / 2);

        // canvas.drawRect(totalX, totalY, totalX + totalWidth, totalY + totalHeight, debugPaint); //Used for debug purposes

        float currentX = totalX;

        for (int i = 0; i<itemCount; i++) {

            float wormWidth = circleDiameter;
            if(i == currentItemIndex){
                wormWidth += (circleEnlargement * (1 - currentOffset));
            }
            if(i == (currentItemIndex+1)){
                wormWidth += (circleEnlargement * (currentOffset));
            }

            tempRect.set(currentX,
                    totalY,
                    currentX + wormWidth,
                    totalY + circleDiameter);

            canvas.drawRoundRect(
                    tempRect,
                    circleRadius,
                    circleRadius,
                    circlePaint
                    );

            currentX += wormWidth;
            currentX += circlePadding;
        }
    }



    public void setState(int itemCount, int currentItemIndex, float currentOffset){
        Log.i("BZZZ", "setState " + itemCount + " " + currentItemIndex + " " + currentOffset);
        this.itemCount = itemCount;
        this.currentItemIndex = currentItemIndex;
        this.currentOffset = currentOffset;
        invalidate();
    }
}
