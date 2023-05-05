package com.example.timelychefs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    private Button General;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        General=findViewById(R.id.GeneralPage);
        button = (Button) findViewById(R.id.HomeP);
        General.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Settings.this,Dashboard.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }
        });
    }
    public void openMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}