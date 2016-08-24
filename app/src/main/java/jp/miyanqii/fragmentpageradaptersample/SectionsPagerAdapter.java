package jp.miyanqii.fragmentpageradaptersample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        return PlaceholderFragment.newInstance(position + 1);
        return ItemFragment.newInstance(0);
    }

    @Override
    public int getCount() {
        // Show 9 total pages.
        return 9;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "歴史/史跡";
            case 1:
                return "観る/自然スポット";
            case 2:
                return "食べる";
            case 3:
                return "泊まる";
            case 4:
                return "遊ぶ";
            case 5:
                return "会う";
            case 6:
                return "観光イベント";
            case 7:
                return "ツアー";
            case 8:
                return "体験する";
        }
        return null;
    }
}