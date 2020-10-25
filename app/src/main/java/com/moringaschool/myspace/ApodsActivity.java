package com.moringaschool.myspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.myspace.ui.ApodsListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApodsActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.Date) EditText mDate;
    @BindView(R.id.btnSubmit1) Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apods_list);
        ButterKnife.bind(this);

        mSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mSubmit){
            String date = mDate.getText().toString();
            Intent intent = new Intent(ApodsActivity.this, ApodsListActivity.class);
            intent.putExtra("date", date);
            startActivity(intent);
    }
    }
}