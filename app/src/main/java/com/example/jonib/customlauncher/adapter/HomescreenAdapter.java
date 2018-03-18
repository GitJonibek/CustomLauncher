package com.example.jonib.customlauncher.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jonib.customlauncher.fragment.Homescreen;

/**
 * Created by jonib on 3/17/2018.
 */

public class HomescreenAdapter extends FragmentStatePagerAdapter{

    private static final int NUM_PAGES = 3;

    public HomescreenAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new Homescreen();
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
