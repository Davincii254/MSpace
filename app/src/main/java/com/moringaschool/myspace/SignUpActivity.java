package com.moringaschool.myspace;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Email;
    private EditText Password;
    private EditText PhoneNumber;
    private Button CreateAcc;;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name = (EditText) findViewById(R.id.etName);
        Email = (EditText) findViewById(R.id.etPassword);
        Password = (EditText) findViewById(R.id.etPassword);
        PhoneNumber = (EditText) findViewById(R.id.etNumber);
        CreateAcc = (Button) findViewById(R.id.btnSubmit);

        CreateAcc.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                return false;
            }
        });



    }
}