package ru.pvolan.samplecustomviews.uikit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import ru.pvolan.samplecustomviews.R;

public class ProfileItemView extends ConstraintLayout {
    public ProfileItemView(@NonNull Context context) {
        super(context);
        init(null);
    }

    public ProfileItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ProfileItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public ProfileItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    private ImageView imageIcon;
    private TextView textTitle;
    private TextView textValue;


    private void init(@Nullable AttributeSet attrs){
        View.inflate(getContext(), R.layout.profile_item_view, this);

        imageIcon = findViewById(R.id.imageIcon);
        textTitle = findViewById(R.id.textTitle);
        textValue = findViewById(R.id.textValue);

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.ProfileItemView);

        try {
            String title = ta.getString(R.styleable.ProfileItemView_piv_title);
            if (title != null) setTitle(title);

            String value = ta.getString(R.styleable.ProfileItemView_piv_value);
            if (value != null) setValue(value);

            int iconRes = ta.getResourceId(R.styleable.ProfileItemView_piv_icon, -1);
            if (iconRes != -1) setIcon(iconRes);
        } finally {
            ta.recycle();
        }
    }



    public void setTitle(CharSequence text) {
        textTitle.setText(text);
    }

    public void setTitle(int resid) {
        textTitle.setText(resid);
    }

    public void setValue(CharSequence text) {
        textValue.setText(text);
    }

    public void setValue(int resid) {
        textValue.setText(resid);
    }

    public void setIcon(int resid) {
        imageIcon.setImageResource(resid);
    }

    public void setIcon(Drawable drawable) {
        imageIcon.setImageDrawable(drawable);
    }

}
