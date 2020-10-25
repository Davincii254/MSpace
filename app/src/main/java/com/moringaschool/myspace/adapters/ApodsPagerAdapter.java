package com.moringaschool.myspace.adapters;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.myspace.models.Apods;
import com.moringaschool.myspace.ui.ApodsDetailFragment;

import java.util.List;

public class ApodsPagerAdapter extends FragmentPagerAdapter {
    private List<Apods> mApods;

    public ApodsPagerAdapter(FragmentManager fm, int behavior, List<Apods> apods) {
        super(fm, behavior);

        mApods = apods;
    }

    public ApodsDetailFragment getItem(int position) {
        return ApodsDetailFragment.newInstance(mApods.get(position));
    }

    @Override
    public int getCount() {
        return mApods.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mApods.get(position).getDate();
    }
}