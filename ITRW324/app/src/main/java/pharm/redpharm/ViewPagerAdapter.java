package pharm.redpharm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new About();
        }

        else if (position == 1) {
            return new FirstFragment();
        }

        else if (position == 2) {
            return new SecondFragment();
        }
        else if (position == 3)
        {
            return new ThirdFragment();
        }
        else  return new ThirdFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}