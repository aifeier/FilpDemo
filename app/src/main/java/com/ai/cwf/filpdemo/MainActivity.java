package com.ai.cwf.filpdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return ImageFragment.NewImageFragment(position);
            }

            @Override
            public int getCount() {
                return 5;
            }

        };

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int size = pagerAdapter.getCount() - 1;
                if (size > 1) { //多于1，才会循环跳转
                    if (position < 1) { //首位之前，跳转到末尾（N）
                        viewPager.setCurrentItem(size - 1, true);
                        position = size - 1;
                    } else if (position >= size) { //末位之后，跳转到首位（1）
                        viewPager.setCurrentItem(1, true); //false:不显示跳转过程的动画
                        position = 1;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        viewPager.setCurrentItem(1);
    }
}
