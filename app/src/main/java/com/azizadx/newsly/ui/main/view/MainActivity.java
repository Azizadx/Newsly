package com.azizadx.newsly.ui.main.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.widget.Toast;

import com.azizadx.newsly.R;
import com.azizadx.newsly.data.respository.PageAdapter;
import com.azizadx.newsly.ui.main.adopter.NewsFeedAdaptor;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mrandom,msport,mtech,mhealth,mscience,mbusiness,mentertainment;
    PagerAdapter pagerAdapter;
    String api = "d8874f9df1164bc3af8101018531cedf";
    String cat, key;
    int pos;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrandom = findViewById(R.id.general);
        mbusiness = findViewById(R.id.business);
        mtech = findViewById(R.id.technology);
        mentertainment = findViewById(R.id.entertainment);
        mhealth = findViewById(R.id.health);
        mscience = findViewById(R.id.scinence);
        msport = findViewById(R.id.sports);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.tabinclude);


        pagerAdapter = new PageAdapter(getSupportFragmentManager(),7);

        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                pos = tab.getPosition();
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2
                        ||tab.getPosition()==3||tab.getPosition()==4||
                        tab.getPosition()==5||tab.getPosition()==6){
                    pagerAdapter.notifyDataSetChanged();
    switch (pos) {
        case 0:
            cat ="General";
            break;
        case 1:
            cat ="Business";
            break;
        case 2:
            cat ="Technology";
            break;
        case 3:
            cat ="Entertainment";
            break;
        case 4:
            cat ="Health";
            break;
        case 5:
            cat ="Science";
            break;
        case 6:
            cat ="Sports";
            break;
        default:
            cat ="Uncategorized";
            break;
            }
                }
                setCategory();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        BottomNavigationView bottomNavigationView = findViewById(R.id.navbarr);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.bookmarks:
                        startActivity(new Intent(getApplicationContext()
                                , BookmarksEmptyStateActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        return true;

                }
                return false;
            }

        });
    }

    public  String setCategory() {
         key = cat;
        return  key;
    }


}

