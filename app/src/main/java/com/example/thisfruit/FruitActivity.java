package com.example.thisfruit;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class FruitActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        final MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());

        ViewPager mViewPager = findViewById(R.id.vpPager);
        mViewPager.setAdapter(adapterViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int currentPage = 0;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                FruitFragment fragment = (FruitFragment) adapterViewPager.get(position);


                if (fragment != null &&
                        currentPage != position) {
                    Log.e("Activity", "onPageSelected: stop" + currentPage);
                    ((Callback) adapterViewPager.get(currentPage)).onPageChanged();

                }
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mViewPager.setOffscreenPageLimit(1);
    }


    public interface Callback {
        void onPageChanged();
    }



}
