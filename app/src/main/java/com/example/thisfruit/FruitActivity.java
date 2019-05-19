package com.example.thisfruit;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class FruitActivity extends AppCompatActivity {

    private MyPagerAdapter adapterViewPager;

    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.vpPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int currentPage = 0;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("", "onPageSelected: "+position);
                FruitFragment fragment = (FruitFragment) adapterViewPager.getItem(currentPage);

                Log.e("", "onPageSelected: "+"currentPage  "+currentPage+"   fragment  "+fragment );
                if (fragment instanceof Callback &&
                        currentPage != position) {
                    ((Callback)adapterViewPager.poFrag.get(currentPage)).onPageChanged();

                    Log.e("", "onPageSelected: "+"currentPage  "+currentPage+"   fragment  "+fragment );
                }
                currentPage = position;
                Log.e("", "onPageSelected: "+"currentPage  "+currentPage+"   fragment  "+fragment );

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mViewPager.setOffscreenPageLimit(1);

        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FruitFragment());
        viewPager.setAdapter(adapter);

    }

    public interface Callback {
        void onPageChanged();
    }



}
