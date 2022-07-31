package com.example.newsfeed;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabCount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new homeFragment();
            case 1: return new techFragment();
            case 2: return new healthFragment();
            case 3: return new scienceFragment();
            case 4: return new sportsFragment();
            case 5: return new businessFragment();
            default: return new entertainmentFragment();
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
