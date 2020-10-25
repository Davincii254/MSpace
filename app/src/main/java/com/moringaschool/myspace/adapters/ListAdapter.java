package com.moringaschool.myspace.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myspace.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private String[] mDataset;

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public void ListViewHolder(TextView v) {
            textView = v;
        }

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.apods_list_item, parent, false);
        ListViewHolder viewHolder = new ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
         return mDataset.length;
}
}
