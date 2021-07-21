package ru.pvolan.samplecustomviews.uikit.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class TitleTextView extends AppCompatTextView {

    public TitleTextView(@NonNull Context context) {
        super(context);
        init();
    }

    public TitleTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TitleTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        setTypeface(Typeface.DEFAULT_BOLD);
    }

}
