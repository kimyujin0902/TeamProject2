package com.android.teamproject2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MonthPagerAdapter extends FragmentStateAdapter {
    private static int NUM_ITEMS = 3;
    int year, month;

    public MonthPagerAdapter(FragmentActivity fa, int y, int m) {
        super(fa);
        year = y;
        month = m;

    }

    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                MonthFragment lastM = new MonthFragment();
                lastM.newInstance(year, month-1);
                return lastM;
            case 1:
                MonthFragment thisM = new MonthFragment();
                thisM.newInstance(year, month);
                return thisM;
            case 2:
                MonthFragment nextM = new MonthFragment();
                nextM.newInstance(year, month+1);
                return nextM;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() { return NUM_ITEMS; }

}