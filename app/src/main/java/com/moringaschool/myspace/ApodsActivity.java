package com.moringaschool.myspace;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.myspace.ui.ApodsListActivity;
import com.moringaschool.myspace.ui.SavedApodActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApodsActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.Date) EditText mDate;
    @BindView(R.id.btnSubmit1) Button mSubmit;
    @BindView(R.id.save) Button mSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apods_list);
        ButterKnife.bind(this);

        mSubmit.setOnClickListener(this);
        mSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mSubmit) {
            String date = mDate.getText().toString();
            Intent intent = new Intent(ApodsActivity.this, ApodsListActivity.class);
            intent.putExtra("date", date);
            startActivity(intent);
        }
//        if (view == mSave) {
//            flipIt(view);
//            Intent intent = new Intent(ApodsActivity.this, SavedApodActivity.class);
//            startActivity(intent);
//        }
    }
    private void flipIt(final View viewToFlip) {
        ObjectAnimator flip = ObjectAnimator.ofFloat(viewToFlip, "rotationX", 0f, 360f);
        flip.setDuration(500);
        flip.start();
    }
}
