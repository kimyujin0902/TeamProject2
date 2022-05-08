package com.android.teamproject2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class WeekPagerAdapter extends FragmentStateAdapter {
    private static int NUM_ITEMS = 3;
    int year, month, date;

    public WeekPagerAdapter(FragmentActivity fa, int y, int m, int d) {
        super(fa);
        year = y;
        month = m;
        date = d;
    }
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                WeekFragment lastW = new WeekFragment();
                lastW.newInstance(year, month, date-7);
                return lastW;
            case 1:
                WeekFragment thisW = new WeekFragment();
                thisW.newInstance(year, month, date);
                return thisW;
            case 2:
                WeekFragment nextW = new WeekFragment();
                nextW.newInstance(year, month, date+7);
                return nextW;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
