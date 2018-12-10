package com.codebits.sodalit.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.codebits.sodalit.ListEmergancyFragment;
import com.codebits.sodalit.R;
import com.codebits.sodalit.fragments.ActivityFragment;

public class MySOSPagerAdapter extends FragmentPagerAdapter {
Context mContext;

    public MySOSPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    public MySOSPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                Fragment f1=new ListEmergancyFragment();
                return f1;
            case 1: // Fragment # 0 - This will show FirstFragment different title
                Fragment f2=new ListEmergancyFragment();
                return f2;

            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return mContext.getResources().getString(R.string.add_emeregancy_tab) ;
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return mContext.getResources().getString(R.string.list_emergancy_tab) ;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
