package com.moringaschool.myspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btnLogin) Button mBtnLogin;
    @BindView(R.id.etName) EditText Name;
    @BindView(R.id.etPassword) EditText Password;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        ButterKnife.bind(this);

        mBtnLogin.setOnClickListener(this);


}
    @Override
    public void onClick(View v) {
        validate(Name.getText().toString(), Password.getText().toString());
        if (v == mBtnLogin){
            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }



    public boolean validate (String username, String userPassword) {
        if ((username == "Admin" && userPassword == "1234")) {
        }
        return true;
    } ;
};
