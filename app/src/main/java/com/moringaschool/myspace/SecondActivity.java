package com.moringaschool.myspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() { FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(SecondActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}