package com.moringaschool.myspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.btnSignup) Button mBtnSignup;
    @BindView(R.id.btnSingin) Button mBtnSignin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

}

    @Override
    public void onClick(View view) {
        if (view == mBtnSignin){
            Button btnSignin = (Button) findViewById(R.id.btnSingin);
            btnSignin.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));

        }
        if (view == mBtnSignup){
            Button btnSignup = (Button) findViewById(R.id.btnSignup);
            btnSignup.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SignUpActivity.class)));

        }

    }
}

