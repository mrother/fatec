package com.fatec.maiara.objectloandapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fatec.maiara.objectloandapp.utils.ItemViewHolder;
import com.fatec.maiara.objectloandapp.R;
import com.fatec.maiara.objectloandapp.models.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter{

    private List<Item> items;

    private Context context;

    public interface ItemAdapterListener{
        void onEditItemClick(View view, int position);
        void onDeleteItemClick(View view, int position);
    }

    private ItemAdapterListener listener;

    public ItemAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
        this.listener = (ItemAdapterListener) context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, viewGroup, false);

        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {


        ItemViewHolder holder = (ItemViewHolder) viewHolder;

        Item item = items.get(position);

        holder.getDescriptionTextView().setText(item.getDescription());
        holder.getNameTextView().setText(item.getName());
        holder.getDateTextView().setText(item.getDate());
        holder.getEditButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEditItemClick(v, position);
            }
        });

        holder.getDeleteButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDeleteItemClick(v, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
