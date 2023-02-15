package com.example.timelychefs;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BrowseAdapter extends RecyclerView.Adapter<BrowseViewHolder> {
    Context context;
    List<BrowseItem> items;

    public BrowseAdapter(Context context, List<BrowseItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public BrowseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BrowseViewHolder(LayoutInflater.from(context).inflate(R.layout.browselistitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BrowseViewHolder holder, int position) {
        holder.recipeView.setText((items.get(position).getRecipe()));
        holder.authorView.setText((items.get(position).getAuthor()));
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
