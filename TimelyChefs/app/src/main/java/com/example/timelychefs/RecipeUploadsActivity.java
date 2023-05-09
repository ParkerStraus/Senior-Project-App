package com.example.timelychefs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeUploadsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecipeImageAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<RecipeImage> mRecipeImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_image);

        int accountId = getLoggedInAccountId();

        // Initialize the RecyclerView
        mRecyclerView = findViewById(R.id.recipe_image_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Fetch the recipe images from the database using PHP
        fetchRecipeImages(accountId);
    }

    private void fetchRecipeImages(int accountId) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://example.com/fetch_recipe_images.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // Parse the JSON response from PHP
                            JSONArray jsonArray = new JSONArray(response);
                            mRecipeImages = new ArrayList<>();

                            // Add each recipe image to the list
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int imageId = jsonObject.getInt("id");
                                String imageName = jsonObject.getString("imagename");
                                String imageUrl = jsonObject.getString("filename");
                                mRecipeImages.add(new RecipeImage(imageId, imageName, imageUrl));
                            }

                            // Create the adapter and set it to the RecyclerView
                            mAdapter = new RecipeImageAdapter(mRecipeImages);
                            mRecyclerView.setAdapter(mAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RecipeImageActivity.this, "Error fetching recipe images: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("accountId", String.valueOf(accountId));
                return params;
            }
        };

        // Add the request to the RequestQueue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    // RecipeImage class to hold the image ID, name, and URL
    private static class RecipeImage {
        private int id;
        private String name;
        private String url;

        public RecipeImage(int id, String name, String url) {
            this.id = id;
            this.name = name;
            this.url = url;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

    // RecipeImageAdapter class for the RecyclerView
    private static class RecipeImageAdapter extends RecyclerView.Adapter<RecipeImageAdapter.RecipeImageViewHolder> {
        private ArrayList<RecipeImage> mRecipeImages;

        public static class RecipeImageViewHolder extends RecyclerView.ViewHolder {
            public ImageView mImageView;
            public TextView mNameTextView;

            public RecipeImageViewHolder(View itemView) {
                super(itemView);
                mImageView = itemView.findViewById(R.id.recipe_image_view);
                mNameTextView = itemView.findViewById(R.id.recipe_name_text_view);
            }
        }

        public RecipeImageAdapter(ArrayList<RecipeImage> recipeImages) {
            mRecipeImages = recipeImages;
        }

    }
}