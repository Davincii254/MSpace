package com.moringaschool.myspace.models;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.myspace.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.btnSignup) Button mBtnSignup;
    @BindView(R.id.btnSingin) Button mBtnSignin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBtnSignin.setOnClickListener(this);
        mBtnSignup.setOnClickListener(this);

}

    @Override
    public void onClick(View v) {
        if (v == mBtnSignin){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if (v == mBtnSignup){
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }

    }
}

