package com.moringaschool.myspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.satelliteTextView) TextView mSatelliteTextView;
    @BindView(R.id.listView) TextView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        mSatelliteTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mSatelliteTextView) {
            Intent intent = new Intent(SecondActivity.this, SatelliteActivity.class);
            startActivity(intent);
        }
    }
}