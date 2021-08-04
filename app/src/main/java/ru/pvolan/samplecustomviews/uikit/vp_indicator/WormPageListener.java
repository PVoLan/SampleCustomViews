package ru.pvolan.samplecustomviews.uikit.vp_indicator;

import android.util.Log;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class WormPageListener implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private WormIndicatorView wormIndicatorView;


    public WormPageListener(ViewPager viewPager, WormIndicatorView wormIndicatorView) {
        this.viewPager = viewPager;
        this.wormIndicatorView = wormIndicatorView;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        PagerAdapter adapter = viewPager.getAdapter();
        int itemsCount = adapter != null ? adapter.getCount() : 0;

        wormIndicatorView.setState(
                itemsCount,
                position,
                positionOffset
        );
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
};
