package com.evilstan.mornhousetesttask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evilstan.mornhousetesttask.databinding.ListItemBinding;

import java.util.List;


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    static List<NumberInfo> dataSet;
    private final OnHistoryClickListener onHistoryClickListener;

    public HistoryAdapter(List<NumberInfo> dataSet, OnHistoryClickListener onHistoryClickListener) {
        HistoryAdapter.dataSet = dataSet;
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
        holder.setDescription(dataSet.get(position).getDescription());
        holder.setNumber(dataSet.get(position).getNumber());

        holder.itemView.setOnClickListener(v -> onHistoryClickListener.onItemClick(numberInfo));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    //TODO refactor
    interface OnHistoryClickListener {
        void onItemClick(NumberInfo numberInfo);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding binding;

/*        private final MaterialTextView numberText;
        private final MaterialTextView descriptionText;*/

        public ViewHolder(View view) {
            super(view);
            binding = ListItemBinding.inflate(LayoutInflater.from(view.getContext()));

            //TODO check, if working - delete commented text
/*            numberText = view.findViewById(R.id.number_text);
            descriptionText = view.findViewById(R.id.description_text);*/
        }

        public void setNumber(int number) {
            binding.numberText.setText(number);
        }

        public void setDescription(String text) {
            binding.descriptionText.setText(text);
        }
    }

}
