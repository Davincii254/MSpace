package com.moringaschool.myspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSignin = (Button) findViewById(R.id.btnSingin);
        btnSignin.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));

        Button btnSignup = (Button) findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SignUpActivity.class)));
}}

