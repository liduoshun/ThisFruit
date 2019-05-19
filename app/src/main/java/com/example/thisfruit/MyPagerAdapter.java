package com.example.thisfruit;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    @SuppressLint("UseSparseArrays")
    static Map<Integer, FruitFragment> poFrag = new HashMap<>();


    protected final List<FruitFragment> mFragmentList;


    void addFragment(FruitFragment fragment) {
        mFragmentList.add(fragment);
    }

    MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        mFragmentList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        FruitFragment vaFragment = FruitFragment.newInstance(position);
        poFrag.put(position, vaFragment);
        return vaFragment;
    }


    @Override
    public int getCount() {
        return 17;
    }

}
