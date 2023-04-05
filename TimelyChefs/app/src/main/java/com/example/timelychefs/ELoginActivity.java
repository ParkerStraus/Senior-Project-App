package com.example.timelychefs;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ELoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button registerBtn = (Button)findViewById(R.id.toRegister);
        Button login = (Button)findViewById(R.id.loginbutton);
        EditText usern   = (EditText)findViewById(R.id.username);
        EditText passw = (EditText) findViewById(R.id.password);
        final String[] uname = new String[1];
        String password;
        EditText username = (EditText) findViewById(R.id.username);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ELoginActivity.this, RegisterActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                uname[0] = username.getText().toString();
            }
        });
    }

}
