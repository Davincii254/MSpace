package com.moringaschool.myspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.moringaschool.myspace.ui.ApodsListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView tvMain;
    @BindView(R.id.button1) Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);


        mButton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mButton1){
            Intent intent = new Intent(SecondActivity.this, ApodsListActivity.class);
            startActivity(intent);
            finish();
        }
    }
}