package com.zimba.architecturesampleproject.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.zimba.architecturesampleproject.R;
import com.zimba.architecturesampleproject.models.Asset;

import java.util.List;

public class AssetRecyclerViewAdapter extends ListAdapter<Asset,
        AssetRecyclerViewAdapter.AssetHolder> {

    private OnItemClickListener clickListener;

    public AssetRecyclerViewAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Asset> DIFF_CALLBACK = new DiffUtil.ItemCallback<Asset>() {
        @Override
        public boolean areItemsTheSame(@NonNull Asset oldItem, @NonNull Asset newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Asset oldItem, @NonNull Asset newItem) {
            return oldItem.getTitle().equalsIgnoreCase(newItem.getTitle())
                    && oldItem.getDescription().equalsIgnoreCase(newItem.getDescription());
        }
    };


    @NonNull
    @Override
    public AssetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.asset_item, parent, false);
        return new AssetHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AssetHolder holder, int position) {
        Asset currentAsset = getItem(position);
        holder.textViewTitle.setText(currentAsset.getTitle());
        holder.textViewDescription.setText(currentAsset.getDescription());

    }

    class AssetHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitle;
        private TextView textViewDescription;

        public AssetHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewTitle =
                    itemView.findViewById(R.id.text_view_title);
            this.textViewDescription =
                    itemView.findViewById(R.id.text_view_description);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (clickListener != null && position != RecyclerView.NO_POSITION) {
                        clickListener.onItemClicked(getItem(position));
                    }
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onItemClicked(Asset asset);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
