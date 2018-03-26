package com.d3ifcool.park_in;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.d3ifcool.park_in.ContentRiwayatFragment.RiwayatFragment;

/**
 * Created by Aldir on 3/25/2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter{

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new ParkFragment();
        } else{
            return new RiwayatFragment();
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "BERANDA";
        } else {
            return  "RIWAYAT";
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
