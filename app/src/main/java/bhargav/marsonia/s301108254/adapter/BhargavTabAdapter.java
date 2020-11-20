package bhargav.marsonia.s301108254.adapter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import bhargav.marsonia.s301108254.fragments.BhargavFragmentAddPatient;
import bhargav.marsonia.s301108254.fragments.BhargavFragmentSearch;

public class BhargavTabAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;
    public BhargavTabAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                BhargavFragmentSearch jaskaranFragmentSearch = new BhargavFragmentSearch();
                return jaskaranFragmentSearch;
            case 1:
                BhargavFragmentAddPatient jaskaranFragmentAddPatient = new BhargavFragmentAddPatient();
                return jaskaranFragmentAddPatient;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }

}
