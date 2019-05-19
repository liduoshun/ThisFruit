package com.example.thisfruit;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class FruitActivity extends AppCompatActivity {

    private MyPagerAdapter adapterViewPager;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.vpPager);

        mViewPager.setOffscreenPageLimit(3);

        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FruitFragment());
        viewPager.setAdapter(adapter);
    }
}
