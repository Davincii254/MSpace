package com.moringaschool.myspace.models;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.myspace.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.btnSubmit) Button mBtnSubmit;
    @BindView(R.id.etName) EditText Name;
    @BindView(R.id.etEmail) EditText Email;
    @BindView(R.id.etPassword) EditText Password;
    @BindView(R.id.etNumber) EditText PhoneNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        mBtnSubmit.setOnClickListener(this);

    }

   public boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

   public boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

   public void checkDataEntered() {
        if (isEmpty(Name)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(PhoneNumber)) {
            PhoneNumber.setError("PhoneNumber is required!");
        }

        if (!isEmail(Email)) {
            Email.setError("Enter valid Email!");
        }

    }

    @Override
    public void onClick(View view) {
        if (view == mBtnSubmit) {
            isEmail(Email);
            isEmpty(PhoneNumber);
            isEmpty(Name);
            isEmpty(Password);
            Intent intent = new Intent(SignUpActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }
}


