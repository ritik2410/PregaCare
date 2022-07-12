package com.example.pregacare;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerActivity extends FragmentPagerAdapter {

    public PagerActivity(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {

        switch(position) {
            case 0: return new DetailEntry();
            case 1: return new Info();
            default : return null;
        }
    }
    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "GESTATIONAL DIABETES TEST";
            case 1: return "ABOUT GESTATIONAL DIABETES";
        }
        return super.getPageTitle(position);
    }
}