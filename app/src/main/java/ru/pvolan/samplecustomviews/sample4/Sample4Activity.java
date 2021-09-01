package ru.pvolan.samplecustomviews.sample4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.pvolan.samplecustomviews.R;
import ru.pvolan.samplecustomviews.uikit.custom_drawable.CustomDrawable;

public class Sample4Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_4);

        TextView textHello = findViewById(R.id.textHello);
        textHello.setBackgroundDrawable(new CustomDrawable());
    }


}