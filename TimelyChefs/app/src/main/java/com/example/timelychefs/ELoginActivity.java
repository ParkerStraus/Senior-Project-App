package com.example.timelychefs;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ELoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button registerBtn = (Button)findViewById(R.id.toRegister);
        Button login = (Button)findViewById(R.id.loginbutton);
        EditText usern   = (EditText)findViewById(R.id.username);
        EditText passw = (EditText) findViewById(R.id.password);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ELoginActivity.this, RegisterActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String URL = "http://se4500seniorproject.atwebpages.com/loginAccount.php?u="+usern.getText().toString()+"&p="+ passw.getText().toString();

                //Toast logintoast = Toast.makeText(getApplicationContext(), "Logging in...", Toast.LENGTH_SHORT);
                //logintoast.show();

                // Request a JSON response from the provided URL.

                getJSON(URL);
            }
        });
    }

    private void loginHandler(String json) throws JSONException {
        if(json != "-1") {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject obj = jsonArray.getJSONObject(0);
            //"username":"strau307","2":"strau307@crk.umn.edu","email":"strau307@crk.umn.edu","3":"1","ISPASSWORDCORRECT":"1"}
            int Accid = obj.getInt("AccountID");
            String username = obj.getString("username");
            int ISPASSWORDCORRECT = obj.getInt("ISPASSWORDCORRECT");

            //Test if password is correct
            if(ISPASSWORDCORRECT == 1){
                //matches
                Toast.makeText(this, "password is correct", Toast.LENGTH_SHORT).show();
            }
            else{
                //incorrect password
                Toast.makeText(this, "password is incorrect", Toast.LENGTH_SHORT).show();
            }
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
                    loginHandler(s);
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

                    return "-1";
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }


}
