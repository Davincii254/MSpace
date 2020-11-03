package com.moringaschool.myspace.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.myspace.Constants;
import com.moringaschool.myspace.R;
import com.moringaschool.myspace.adapters.ApodAdapter;
import com.moringaschool.myspace.models.Apods;

public class SavedApodActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ApodAdapter adapter; // Create Object of the Adapter class
    DatabaseReference mbase; // Create object of the

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_apod);

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid = user.getUid();


    mbase = FirebaseDatabase.getInstance()
            .getReference(Constants.FIREBASE_CHILD_APODS)
                .child(uid);

    recyclerView = findViewById(R.id.recycler1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    FirebaseRecyclerOptions<Apods> options = new FirebaseRecyclerOptions.Builder<Apods>()
            .setQuery(mbase, Apods.class)
            .build();

    adapter = new ApodAdapter(options);
        recyclerView.setAdapter(adapter);
}


    @Override protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}