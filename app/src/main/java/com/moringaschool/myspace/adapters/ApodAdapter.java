package com.moringaschool.myspace.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
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

public class  ApodAdapter extends FirebaseRecyclerAdapter<Apods, ApodAdapter.ApodViewholder> {

    private static final String TAG = "Bookmarked news";
    DatabaseReference reference;
    Context mContext;
    private Apods apods;



    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */


    public ApodAdapter(@NonNull FirebaseRecyclerOptions<Apods> options) {
        super(options);
    }

    @NonNull
    @Override
    public ApodViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.apod_list_item_drag, parent, false);
        return new ApodViewholder(view);


    }

    @Override
    public void
    onBindViewHolder(@NonNull ApodViewholder holder, int position, @NonNull Apods model) {


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_APODS).child(uid);
        DatabaseReference usersRef = rootRef.child("Apods");
        usersRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot ds : snapshot.getChildren()) {
                    Apods users = ds.getValue(Apods.class);
                    Log.d("result", "Copyright: " + users.getCopyright() + "date" + users.getDate() + " explanation " + users.getExplanation()
                    + "hdurl" + users.getHdurl() + "media_type" + users.getMediaType() + "service_version" + users.getServiceVersion() + "title" +
                            users.getTitle() + "url" + users.getUrl());
                    holder.copyright.setText(users.getCopyright());
                    holder.date.setText(users.getDate());
                    holder.explanation.setText(users.getExplanation());
                    holder.hdurl.setText(users.getHdurl());
                    holder.media_type.setText(users.getMediaType());
                    holder.service_version.setText(users.getServiceVersion());
                    holder.title.setText(users.getTitle());
                    holder.url.setText(users.getUrl());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public class ApodViewholder extends RecyclerView.ViewHolder {
        public TextView copyright, date, explanation, hdurl, media_type, service_version, title, url;
        public ApodViewholder(@NonNull View itemView) {
            super(itemView);

            copyright = itemView.findViewById(R.id.copyright);
            date = itemView.findViewById(R.id.date);
            explanation = itemView.findViewById(R.id.explanation);
            hdurl = itemView.findViewById(R.id.hdurl);
            media_type = itemView.findViewById(R.id.media_type);
            service_version = itemView.findViewById(R.id.service_version);
            title = itemView.findViewById(R.id.title);
            url = itemView.findViewById(R.id.url);
        }

    }
}
