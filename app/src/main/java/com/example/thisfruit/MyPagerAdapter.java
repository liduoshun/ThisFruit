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


    private Map<Integer, FruitFragment> poFrag;


    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        poFrag = new HashMap<>();
    }

    @Override
    public Fragment getItem(int position) {
        FruitFragment vaFragment = FruitFragment.newInstance(position);
        poFrag.put(position, vaFragment);
        return vaFragment;
    }

    public Fragment get(int position) {
        return poFrag.get(position);
    }
    @Override
    public int getCount() {
        return 17;
    }

}
