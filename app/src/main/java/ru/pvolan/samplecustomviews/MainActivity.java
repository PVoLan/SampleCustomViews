package ru.pvolan.samplecustomviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ru.pvolan.samplecustomviews.sample1.Sample1Activity;
import ru.pvolan.samplecustomviews.sample2.MyPagerAdapter;
import ru.pvolan.samplecustomviews.sample2.Sample2Activity;
import ru.pvolan.samplecustomviews.uikit.ProfileItemView;
import ru.pvolan.samplecustomviews.uikit.vp_indicator.WormIndicatorView;
import ru.pvolan.samplecustomviews.uikit.vp_indicator.WormPageListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Sample1Activity.class));
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Sample2Activity.class));
            }
        });

    }




}