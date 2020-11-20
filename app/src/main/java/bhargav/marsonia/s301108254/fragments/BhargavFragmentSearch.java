package bhargav.marsonia.s301108254.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;

import bhargav.marsonia.s301108254.R;


public class BhargavFragmentSearch extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_bhargav_search, container, false);
        Spinner spinner = v.findViewById(R.id.bhargav_filter);
        BaseAdapter adapter = new ArrayAdapter(getActivity(),  android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.departmentList));
        spinner.setAdapter(adapter);
        return v;
    }
}