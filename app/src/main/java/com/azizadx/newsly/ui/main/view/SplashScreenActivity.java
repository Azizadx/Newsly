package com.azizadx.newsly.ui.main.view;

import com.azizadx.newsly.ui.main.view.base.BaseActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.azizadx.newsly.R;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = authUser();
            startActivity(intent);
        }, 1500);

    }
    }
