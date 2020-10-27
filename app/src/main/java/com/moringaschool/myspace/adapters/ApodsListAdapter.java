package com.moringaschool.myspace.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myspace.models.Apods;
import com.moringaschool.myspace.R;
import com.moringaschool.myspace.ui.ApodDetailActivity;
import com.moringaschool.myspace.ui.ApodsListActivity;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApodsListAdapter extends RecyclerView.Adapter<ApodsListAdapter.ApodViewHolder>  {
    private List<Apods> mApods;
    private Context mContext;

    public ApodsListAdapter(ApodsListActivity context, List<Apods> apods){
        mContext = context;
        mApods = apods;
    }

    @Override
    public int getItemCount() {
        return mApods.size();
    }

    public class ApodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.copyright) TextView mCopyright;
        @BindView(R.id.date) TextView mDate;
        @BindView(R.id.explanation) TextView mExplanation;
        @BindView(R.id.hdurl) TextView mHdurl;
        @BindView(R.id.media_type) TextView mMedia_type;
        @BindView(R.id.service_version) TextView mServiceVersion;
        @BindView(R.id.title) TextView mTittle;
        @BindView(R.id.url) TextView mUrl;



        private Context mContext;

        public ApodViewHolder( View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }


        public void bindApods(Apods apods) {
            mCopyright.setText(apods.getCopyright());
            mDate.setText(apods.getDate());
            mExplanation.setText(apods.getExplanation());
            mHdurl.setText(apods.getHdurl());
            mMedia_type.setText(apods.getMediaType());
            mServiceVersion.setText(apods.getServiceVersion());
            mTittle.setText(apods.getTitle());
            mUrl.setText(apods.getUrl());
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, ApodDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("apods", Parcels.wrap(mApods));
            mContext.startActivity(intent);
        }
    }
    @NonNull
    @Override
    public ApodsListAdapter.ApodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.apods_list, parent, false);
        ApodViewHolder viewHolder = new ApodViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ApodsListAdapter.ApodViewHolder holder, int position) {
        holder.bindApods(mApods.get(position));
    }

}
