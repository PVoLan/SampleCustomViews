package ru.pvolan.samplecustomviews.uikit.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class RegularTextView extends AppCompatTextView {

    public RegularTextView(@NonNull Context context) {
        super(context);
        init();
    }

    public RegularTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RegularTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        setTextColor(0xffff0000);
    }

}
