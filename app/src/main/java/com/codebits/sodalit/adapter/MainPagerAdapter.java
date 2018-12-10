package com.codebits.sodalit.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.codebits.sodalit.R;
import com.codebits.sodalit.fragments.ActivityFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {
Context mContext;

    public MainPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                Fragment f1=new ActivityFragment();
                return f1;
            case 1: // Fragment # 0 - This will show FirstFragment different title
                Fragment f2=new ActivityFragment();
                return f2;
            case 2: // Fragment # 1 - This will show SecondFragment
                Fragment f3=new ActivityFragment();
                return f3;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return mContext.getResources().getString(R.string.activity_tab_title) ;
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return mContext.getResources().getString(R.string.household_tab_title) ;
            case 2: // Fragment # 1 - This will show SecondFragment
                return mContext.getResources().getString(R.string.community_tab_title) ;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
