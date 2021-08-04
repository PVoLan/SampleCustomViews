package ru.pvolan.samplecustomviews.sample2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import ru.pvolan.samplecustomviews.R;
import ru.pvolan.samplecustomviews.uikit.vp_indicator.WormIndicatorView;
import ru.pvolan.samplecustomviews.uikit.vp_indicator.WormPageListener;

public class Sample2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_2);

        ViewPager viewPager = findViewById(R.id.viewPager);
        WormIndicatorView wormIndicatorView = findViewById(R.id.indicatorView);

        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.addOnPageChangeListener(new WormPageListener(viewPager, wormIndicatorView));
    }


}