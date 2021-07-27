package com.azizadx.newsly.ui.main.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.azizadx.newsly.R;

public class WelcomeScreenActivity extends AppCompatActivity {
    private Button getStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        getStarted = findViewById(R.id.getStartedBtn);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (WelcomeScreenActivity.this, SignUpActivity.class);

                startActivity(intent);
            }
        });
    }
}