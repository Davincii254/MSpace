package com.moringaschool.myspace;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.btnSubmit) Button mBtnSubmit;


    EditText Name;
    EditText Email;
    EditText Password;
    EditText PhoneNumber;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.etName);
        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        PhoneNumber = findViewById(R.id.etNumber);
        Submit = findViewById(R.id.btnSubmit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(Name)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(PhoneNumber)) {
            PhoneNumber.setError("PhoneNumber is required!");
        }

        if (isEmail(Email) == false) {
            Email.setError("Enter valid Email!");
        }

    }

    @Override
    public void onClick(View view) {
        if (view == mBtnSubmit){
            Button btnSubmit = (Button) findViewById(R.id.btnSingin);
            btnSubmit.setOnClickListener(v -> startActivity(new Intent(SignUpActivity.this, SecondActivity.class)));

        }
    }
}


