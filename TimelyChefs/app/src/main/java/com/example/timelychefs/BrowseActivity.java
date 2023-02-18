package com.example.timelychefs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        RecyclerView recyclerView = findViewById(R.id.recipeList);

        List<BrowseItem> items = new ArrayList<BrowseItem>();
        items.add(new BrowseItem("Spaghetti", "Mario", R.drawable.roast));
        items.add(new BrowseItem("Pizza", "Luigi", R.drawable.roast));
        items.add(new BrowseItem("Tortellini", "Wario", R.drawable.roast));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BrowseAdapter(getApplicationContext(),items));
    }
}
