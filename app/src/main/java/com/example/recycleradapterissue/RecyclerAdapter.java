package com.example.recycleradapterissue;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.view.LayoutInflater.from;

final class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.BaseViewHolder> {

    private final List<Item> data = new ArrayList<>();

    void setData(List<Item> items) {
        data.clear();
        data.addAll(items);
        notifyItemChanged(0);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Log.d("+++", "onBindViewHolder pos: " + position);
        Item item = data.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.messageTextView.setText(item.getMessage());
        holder.itemView.setPadding(0, 0, 0, 0);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(final int position) {
        Item item = (Item) getItem(position);
        if (item != null) {
            return item.getId();
        } else {
            return -1; // see item.getId().
        }
    }

    private Object getItem(int position) {
        if (getItemCount() > position) {
            return data.get(position);
        } else {
            return null;
        }
    }

    static class BaseViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView messageTextView;

        BaseViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.tv_title);
            messageTextView = itemView.findViewById(R.id.tv_message);
        }
    }
}
