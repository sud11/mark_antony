package com.sud.markantony;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hema on 6/5/17.
 */
public class Pager extends FragmentStatePagerAdapter {
    int tabCount;

    public Pager(FragmentManager fm, int tabCount)
    {
        super(fm);
        this.tabCount=tabCount;

    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                quickQuotesFragment quotesFragment = new quickQuotesFragment();
                return quotesFragment;
            case 1:
                quickInsultsFragment insultsFragment = new quickInsultsFragment();
                return insultsFragment;
            case 2:
                quickTranslationsFragment translationsFragment = new quickTranslationsFragment();
                return translationsFragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
