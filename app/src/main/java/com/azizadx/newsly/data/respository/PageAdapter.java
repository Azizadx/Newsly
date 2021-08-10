package com.azizadx.newsly.data.respository;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.azizadx.newsly.ui.main.view.newsfragment.GeneralFrg;

public class PageAdapter extends FragmentPagerAdapter {

    int tabcount = 1;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new GeneralFrg();
//            case 1:
//                return new SportFrg();
//            case 2:
//                return new TechFrg();
//            case 3:
//                return new HealthFrg();
            default:
                return null;
        }
    }




    @Override
    public int getCount() {
        return tabcount;
    }
}
