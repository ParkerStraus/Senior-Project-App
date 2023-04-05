package com.example.timelychefs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getJSON("http://se4500seniorproject.atwebpages.com/getSingleRecipe.php?recipe="+this.getIntent().getExtras().get("recipeID"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipeview);
    }

    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        ArrayList<BrowseItem> items = new ArrayList<BrowseItem>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            final TextView recipename = (TextView) findViewById(R.id.recipeName);
            recipename.setText(obj.getString("title"));
            final TextView recipedescription = (TextView) findViewById(R.id.recipeDescription);
            recipedescription.setText(obj.getString("description"));
            final TextView recipeIngr = (TextView) findViewById(R.id.recipeIngredients);
            recipeIngr.setText(obj.getString("ingredients"));
            final TextView recipeInst = (TextView) findViewById(R.id.recipeinstruct);
            recipeInst.setText(obj.getString("instructions"));
            final TextView authorname = (TextView) findViewById(R.id.recipeAuthor);
            String authortext = "Made by " + obj.getString("displayName");
            authorname.setText(authortext);
        }
    }

    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                Log.d("d",s);
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {

                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    Log.d("d", "Wow Look Noting");

                    return "[{\"title\":\"Sorry\",\"description\":\"Mamma mia! I eat-a a meatball!\",\"recipeID\":\"1\",\"displayName\":\"Something went wrong\"}" +
                            ",{\"title\":\""+ e.toString() + "\",\"description\":\"Mamma mia! I eat-a a meatball!\",\"recipeID\":\"1\",\"displayName\":\"Something went wrong\"}]";
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }
}