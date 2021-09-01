package ru.pvolan.samplecustomviews.uikit.custom_drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomDrawable extends Drawable {


    private Paint circlePaint;
    private RectF tempRect = new RectF();

    public CustomDrawable() {
        circlePaint = new Paint();
        circlePaint.setColor(0xff555599);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
    }


    @Override
    public void draw(@NonNull Canvas canvas) {

        Rect rect = getBounds();

        tempRect.set(rect.left, rect.top, rect.right, rect.bottom);
        canvas.drawOval(tempRect, circlePaint);
    }


    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

}
