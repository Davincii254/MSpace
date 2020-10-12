package com.moringaschool.myspace;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class SatelliteArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mSatellite;

    public SatelliteArrayAdapter(Context mContext, int resource,  String[] mSatellite) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mSatellite = mSatellite;
    }
    @Override
    public Object getItem(int position) {
        String satellite = mSatellite[position];
        return String.format("%s \nServes great: %s", satellite);
    }

    @Override
    public int getCount() {
        return mSatellite.length;
    }
}
