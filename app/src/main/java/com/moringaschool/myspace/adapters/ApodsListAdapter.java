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
    private ApodsListActivity mContext;

    public ApodsListAdapter(ApodsListActivity context, List<Apods> apods){
        mContext = context;
        mApods = apods;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ApodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.Date) TextView mDate;
        @BindView(R.id.Apodimage) ImageView mApodimage;

        private Context mContext;

        public ApodViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }


        public void bindApods(Apods apods) {
            mDate.setText(Apods.getDate());

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
