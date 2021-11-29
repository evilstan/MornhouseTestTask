package com.evilstan.mornhousetesttask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>  {
//TODO refactor
    interface OnHistoryClickListener{
        void onItemClick(NumberInfo numberInfo, int position);
    }

    private final OnHistoryClickListener onHistoryClickListener;
    List<NumberInfo> dataSet;


    public HistoryAdapter(List<NumberInfo> dataSet, OnHistoryClickListener onHistoryClickListener) {
        this.dataSet = dataSet;
        this.onHistoryClickListener = onHistoryClickListener;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        NumberInfo numberInfo = dataSet.get(position);
        holder.getNumberText().setText(dataSet.get(position).getNumber());
        holder.getDescriptionText().setText(dataSet.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHistoryClickListener.onItemClick(numberInfo, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final MaterialTextView numberText;
        private final MaterialTextView descriptionText;

        public ViewHolder(View view) {
            super(view);
            numberText = view.findViewById(R.id.number_text);
            descriptionText = view.findViewById(R.id.description_text);
        }

        public MaterialTextView getNumberText() {
            return numberText;
        }

        public MaterialTextView getDescriptionText() {
            return descriptionText;
        }
    }

}
