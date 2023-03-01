package com.example.timelychefs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BrowseAdapter extends RecyclerView.Adapter<BrowseAdapter.BrowseViewHolder>{

    Context context;
    List<BrowseItem> items;
    private BrowseViewInterface browseViewInterface;

    public BrowseAdapter(Context context, List<BrowseItem> items, BrowseViewInterface browseViewInterface) {
        this.context = context;
        this.items = items;
        this.browseViewInterface = browseViewInterface;
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

    class BrowseViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView recipeView, authorView;

        public BrowseViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            recipeView = itemView.findViewById(R.id.recipetitle);
            authorView = itemView.findViewById(R.id.authorTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    browseViewInterface.OnItemClick(getAdapterPosition());
                }
            });

            itemView.setOnLongClickListener((view -> {

                browseViewInterface.OnLongItemClick(getAdapterPosition());
                return true;
            }));

        }
    }
}
