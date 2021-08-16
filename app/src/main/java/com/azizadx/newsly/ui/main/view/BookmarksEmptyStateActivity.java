package com.azizadx.newsly.ui.main.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.azizadx.newsly.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BookmarksEmptyStateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks_empty_state);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navbarr);

        bottomNavigationView.setSelectedItemId(R.id.bookmarks);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bookmarks:
                        return true;

                }
                return false;
            }

        });
    }
}