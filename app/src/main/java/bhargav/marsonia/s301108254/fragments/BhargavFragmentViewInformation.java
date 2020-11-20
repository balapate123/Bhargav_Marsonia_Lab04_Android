package bhargav.marsonia.s301108254.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import bhargav.marsonia.s301108254.R;
import bhargav.marsonia.s301108254.adapter.BhargavTabAdapter;



public class BhargavFragmentViewInformation extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    public BhargavFragmentViewInformation() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_bhargav_view_information, container, false);
        tabLayout = v.findViewById(R.id.tabLayout);
        viewPager = v.findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("My Patients"));
        tabLayout.addTab(tabLayout.newTab().setText("All Patients"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final BhargavTabAdapter adapter = new BhargavTabAdapter(getContext(),getActivity().getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        return v;
    }
}