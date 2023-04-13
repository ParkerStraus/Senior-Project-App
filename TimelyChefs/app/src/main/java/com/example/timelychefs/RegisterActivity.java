package com.example.timelychefs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btn = (Button)findViewById(R.id.register);
        defineButtons();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, ELoginActivity.class));
            }
        });
        //testing github dumbbussery//
    }


    private void defineButtons() {
        findViewById(R.id.homebutton).setOnClickListener(buttonClickListener);
        findViewById(R.id.profileicon).setOnClickListener(buttonClickListener);
        findViewById(R.id.explorebutton).setOnClickListener(buttonClickListener);
        findViewById(R.id.addnewrecipebutton).setOnClickListener(buttonClickListener);
        findViewById(R.id.browsebutton).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()) {
                case R.id.homebutton:
                    intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.profileicon:
                    intent = new Intent(RegisterActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    break;
                case R.id.explorebutton:
                    break;
                case R.id.addnewrecipebutton:
                    break;
                case R.id.browsebutton:

                    intent = new Intent(RegisterActivity.this, BrowseActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}
