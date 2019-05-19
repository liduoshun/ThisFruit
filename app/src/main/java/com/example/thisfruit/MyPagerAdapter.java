package com.example.thisfruit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private final List<FruitFragment> mFragmentList = new ArrayList<>();


    public void addFragment(FruitFragment fragment){
        mFragmentList.add(fragment);
    }

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return FruitFragment.newInstance(position);
    }


    @Override
    public int getCount() {
        return 5;
    }


}
