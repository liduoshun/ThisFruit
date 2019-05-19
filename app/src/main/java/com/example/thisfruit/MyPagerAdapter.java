package com.example.thisfruit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public Map<Integer, Fragment> poFrag = new HashMap<>();

    private final List<FruitFragment> mFragmentList = new ArrayList<>();


    public void addFragment(FruitFragment fragment){
        mFragmentList.add(fragment);
    }

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment vaFragment = FruitFragment.newInstance(position);
        poFrag.put(position,vaFragment);
        return vaFragment;
    }


    @Override
    public int getCount() {
        return 17;
    }

}
