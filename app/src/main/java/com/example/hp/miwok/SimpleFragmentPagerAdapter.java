package com.example.hp.miwok;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
       super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new NumbersFragment();
        } else if (i == 1) {
            return new FamilyFragment();
        }  else if (i == 2){
            return new ColorsFragment();
        }  else {
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.family);
        } else if (position == 2) {
            return mContext.getString(R.string.colors);
        } else {
            return mContext.getString(R.string.phrases);
        }
    }
}
