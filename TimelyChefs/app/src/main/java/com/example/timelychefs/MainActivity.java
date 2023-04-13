package com.example.timelychefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineButtons();
    }

    public void defineButtons() {
        findViewById(R.id.homebutton).setOnClickListener(buttonClickListener);
        findViewById(R.id.profileIcon).setOnClickListener(buttonClickListener);
        findViewById(R.id.explorebutton).setOnClickListener(buttonClickListener);
        findViewById(R.id.addnewrecipebutton).setOnClickListener(buttonClickListener);
        findViewById(R.id.browsebutton).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        View.OnClickListener context = this;
        Intent intent;
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.homebutton:
                    intent
                    break;
                case R.id.profileIcon:
                    //intent = new Intent(MainActivity.this, RegisterActivity)
                    break;
                case R.id.explorebutton:
                    break;
                case R.id.addnewrecipebutton:
                    break;
                case R.id.browsebutton:

                    intent = new Intent(MainActivity.this, BrowseActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}