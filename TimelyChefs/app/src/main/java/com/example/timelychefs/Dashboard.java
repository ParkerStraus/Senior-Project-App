package com.example.timelychefs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        button = (Button) findViewById(R.id.MainAct);
        button = (Button) findViewById(R.id.Browse);
        button = (Button) findViewById(R.id.Profile);
        button = (Button) findViewById(R.id.Settings);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBrowse();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfile();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettings();
            }
        });
    }
    public void openMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void openBrowse(){
        Intent intent = new Intent(this,BrowseActivity.class);
        startActivity(intent);
    }
    public void openProfile(){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
    public void openSettings(){
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }

}