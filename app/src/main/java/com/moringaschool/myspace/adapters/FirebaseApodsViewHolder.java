package com.moringaschool.myspace.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.myspace.Constants;
import com.moringaschool.myspace.R;
import com.moringaschool.myspace.models.Apods;
import com.moringaschool.myspace.ui.ApodDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;

public class FirebaseApodsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
    @BindView(R.id.copyright) TextView mCopyright;
    @BindView(R.id.date) TextView mDate;
    @BindView(R.id.explanation) TextView mExplanation;
    @BindView(R.id.hdurl) TextView mHdurl;
    @BindView(R.id.media_type) TextView mMedia_type;
    @BindView(R.id.service_version) TextView mServiceVersion;
    @BindView(R.id.title) TextView mTittle;
    @BindView(R.id.url) TextView mUrl;
    @BindView(R.id.save) Button mSave;

    Context mContext;
    public TextView copyright;
    public TextView date;
    public TextView explanation;
    public TextView hdurl;
    public TextView media_type;
    public TextView service_version;
    public TextView tittle;
    public TextView url;
    public Button save;


    public FirebaseApodsViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
//        mView = itemView;
//        mContext = itemView.getContext();
//        itemView.setOnClickListener(this);

        copyright = itemView.findViewById(R.id.copyright);
        date = itemView.findViewById(R.id.date);
        explanation = itemView.findViewById(R.id.explanation);
        hdurl = itemView.findViewById(R.id.hdurl);
        media_type = itemView.findViewById(R.id.media_type);
        service_version = itemView.findViewById(R.id.service_version);
        tittle = itemView.findViewById(R.id.title);
        url = itemView.findViewById(R.id.url);
        save = itemView.findViewById(R.id.save);
    }

    @Override
    public void onClick(View v) {

        final ArrayList<Apods> apods = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference reference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_APODS)
                .child(uid);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    apods.add(snapshot.getValue(Apods.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, ApodDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("apods", Parcels.wrap(apods));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}