package ru.pvolan.samplecustomviews.uikit.chesslayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChessLayout extends ViewGroup {


    public ChessLayout(Context context) {
        super(context);
        init();
    }

    public ChessLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChessLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int gridSize = (int) Math.ceil(Math.sqrt(childCount));

        int w = r-l;
        int h = b-t;

        float cellWidth = w/(float)gridSize;
        float cellHeight = h/(float)gridSize;

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                int viewIndex = j*gridSize + i;

                if(viewIndex >= getChildCount()) break;

                View child = getChildAt(viewIndex);

                int childLeft = (int)(i*cellWidth);
                int childRight = (int)((i+1)*cellWidth);
                int childTop = (int)(j*cellHeight);
                int childBottom = (int)((j+1)*cellHeight);

                child.layout(childLeft, childTop, childRight, childBottom);
            }
        }
    }

    

}
