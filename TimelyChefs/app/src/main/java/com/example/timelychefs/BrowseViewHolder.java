package com.example.timelychefs;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BrowseViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView recipeView, authorView;

    public BrowseViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        recipeView = itemView.findViewById(R.id.recipetitle);
        authorView = itemView.findViewById(R.id.authorTitle);
    }
}
