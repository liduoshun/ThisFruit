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

                FruitFragment fragment = (FruitFragment) adapterViewPager.poFrag.get(currentPage);

                Log.e("TAG", "onPageSelected: " + position+ "aa"+currentPage);
                FruitFragment a = new FruitFragment();
                boolean b = fragment instanceof Callback;

                Log.e("ssssss", "onPageSelected:hhhhhhh "+b);

                if (fragment instanceof Callback &&
                        currentPage != position) {

                    Log.e("aaaaaaa", "onPageScrolled: " );
                    ((Callback)adapterViewPager.poFrag.get(currentPage)).onPageChanged();

                }
                boolean c= fragment instanceof Callback;
                Log.e("instan",a+"");
                currentPage = position;
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
