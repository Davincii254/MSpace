package com.moringaschool.myspace.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.moringaschool.myspace.models.Apods;
import com.moringaschool.myspace.R;
import com.moringaschool.myspace.adapters.ApodsListAdapter;
import com.moringaschool.myspace.adapters.ApodsPagerAdapter;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApodDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)  ViewPager mViewPager;
    @BindView(R.id.Apodimage)  ViewPager mApodimage;
    private ApodsListAdapter adapterViewPager;
    private ApodsPagerAdapter pagerAdapter;

    List<Apods> mApods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apod_detail);
        ButterKnife.bind(this);

        mApods = Parcels.unwrap(getIntent().getParcelableExtra("apods"));
        int startingPosition = getIntent().getIntExtra("position", 0);
        adapterViewPager = new ApodsListAdapter(new ApodsListActivity(), mApods);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(startingPosition);
    }
}