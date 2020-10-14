package com.moringaschool.myspace.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.myspace.R;
import com.moringaschool.myspace.Satellite;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SatelliteListAdapter extends RecyclerView.Adapter<SatelliteListAdapter.SatelliteViewHolder> {
    private ArrayList<Satellite> mSatellite = new ArrayList<>();
    private Context mContext;

    public SatelliteListAdapter(Context context, ArrayList<Satellite> satellites){
        mContext = context;
        mSatellite = satellites;
    }


    @NonNull
    @Override
    public SatelliteListAdapter.SatelliteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.satellite_list_item, parent, false);
        SatelliteViewHolder viewHolder = new SatelliteViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SatelliteListAdapter.SatelliteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SatelliteViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.satelliteImageView) ImageView mSatelliteImageView;
        @BindView(R.id.satelliteNameTextView) TextView mSatelliteNameTextView;
        @BindView(R.id.functionTextView) TextView mFunctionTextView;
        @BindView(R.id.launchDayTextView) TextView mLaunchDayTextView;

        private Context mContext;

        public SatelliteViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindSatellite (Satellite satellite){
            mSatelliteNameTextView.setText(satellite.getName());
            mFunctionTextView.setText(satellite.getFunction());
            mLaunchDayTextView.setText(satellite.getLaunchedDay());
            Picasso.get().load(satellite.getImageUrl()).into(mSatelliteImageView);

        }

    }
}
