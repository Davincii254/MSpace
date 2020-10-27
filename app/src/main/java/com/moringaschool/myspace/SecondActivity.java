package com.moringaschool.myspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.moringaschool.myspace.ui.ApodsListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView tvMain;
    @BindView(R.id.button1) ImageButton mButton1;

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
            Intent intent = new Intent(SecondActivity.this, ApodsActivity.class);
            startActivity(intent);
            finish();
        }
    }
}