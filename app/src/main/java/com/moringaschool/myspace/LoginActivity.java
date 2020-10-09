package com.moringaschool.myspace;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView info;
    private Button Login;
    private int counter = 5;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint({"WrongViewCast", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        info = (EditText) findViewById(R.id.tvinfo);
        Login = (Button) findViewById(R.id.btnLogin);

        info.setText("No of attemps remaning:5");

        Login.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
                return false;
            }
        });


    }

    private void validate (String username, String userPassword){
        if((username == "Admin" && userPassword == "1234")){
            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
        }else {
            counter--;

            info.setText("No attempts remaining: " + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled((false));
            }
        }
    }
}
