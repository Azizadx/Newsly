package com.azizadx.newsly.data.respository;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.azizadx.newsly.ui.main.view.newsfragment.BusinessFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.EntertainmentFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.GeneralFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.HealthFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.ScienceFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.SportFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.TechnologyFrg;

public class PageAdapter extends FragmentPagerAdapter {

    int tabcount = 7;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new GeneralFrg();
            case 1:
                return new BusinessFrg();
            case 2:
                return new TechnologyFrg();
            case 3:
                return new EntertainmentFrg();
            case 4:
                return new HealthFrg();
            case 5:
                return new ScienceFrg();
            case 6:
                return new SportFrg();
            default:
                return null;
        }
    }




    @Override
    public int getCount() {
        return tabcount;
    }
}
