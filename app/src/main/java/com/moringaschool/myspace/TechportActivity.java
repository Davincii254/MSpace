package com.moringaschool.myspace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.myspace.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TechportActivity extends AppCompatActivity  {

    EditText editText;
    Button submit;
    DatabaseReference mRoot, mRef;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techport);

        editText = findViewById(R.id.etValue);
        submit = findViewById(R.id.btnSubmit1);
        Button fetchButton = findViewById(R.id.btnFetch);
        final TextView fetchedText = findViewById(R.id.tvValue);

        // Database reference pointing to root of database
        mRoot = FirebaseDatabase.getInstance().getReference();

        // Database reference pointing to demo node
        mRef = mRoot.child("Emails");

        submit.setOnClickListener(v -> {
            String value = editText.getText().toString();

            // Push creates a unique id in database
            mRef.setValue(value);
        });
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        fetchedText.setText(value);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(TechportActivity.this, "Error fetching data", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}