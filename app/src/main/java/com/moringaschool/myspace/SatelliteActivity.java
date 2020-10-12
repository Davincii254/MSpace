package com.moringaschool.myspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SatelliteActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.satelliteTextView) TextView msatelliteTextView;
    ListView mListView;
    private String[] satellite = new String[] {"Chapter 1", "Chapter 2",
            "Chapter 3", "Chapter 4", "Chapter 5", "Landslat",
            "Sentinel", "Tera", "EnviSat", "Worldview",
            "PlanetScope", "Radasat", "ikonos",
            "Quickbird", "kompsat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.satellite_main);
        ButterKnife.bind(this);

        SatelliteArrayAdapter adapter = new SatelliteArrayAdapter(this, android.R.layout.simple_list_item_1, satellite); // must match constructor!        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String satellite = ((TextView)view).getText().toString();
                Toast.makeText(SatelliteActivity.this, satellite, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String satellite = intent.getStringExtra("location");

        msatelliteTextView.setText("Here are all the restaurants near: " + satellite);


    }

    @Override
    public void onClick(View v) {

    }
}
