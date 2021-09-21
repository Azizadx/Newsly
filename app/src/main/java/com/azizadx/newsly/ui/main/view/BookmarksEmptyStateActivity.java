package com.azizadx.newsly.ui.main.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.azizadx.newsly.R;
import com.azizadx.newsly.data.model.BookmarksDB;
import com.azizadx.newsly.data.model.SavedNewsModel;
import com.azizadx.newsly.ui.main.adopter.BookmarksAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class BookmarksEmptyStateActivity extends AppCompatActivity {
    ArrayList<SavedNewsModel> svdnewmodel = new ArrayList<>();
    BookmarksAdapter adapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks_empty_state);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //SET PROPS
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        adapter = new BookmarksAdapter(this, svdnewmodel);

        //retrieve data for recycler view
        retrieve();

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

    private void retrieve() {
        svdnewmodel.clear();
        BookmarksDB db = new BookmarksDB(this);
        Cursor c = db.getAll();

        //empty
        if (c.getCount()>0) {

            while (c.moveToNext()) {

                String name = c.getString(0);
                String img = c.getString(1);
                String url = c.getString(2);
                String cat = c.getString(3);

                //CREATE Saved News Obj
                SavedNewsModel svm = new SavedNewsModel(name, img, url,cat);

                //ADD TO Saved articles
                svdnewmodel.add(svm);
            }

            //SET ADAPTER TO RV
            if (!(svdnewmodel.size() < 0)) {
                mRecyclerView.setAdapter(adapter);
            }

        } else
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, new EmptyBookmarks()).commit();
//        c.moveToNext();


    }
}

