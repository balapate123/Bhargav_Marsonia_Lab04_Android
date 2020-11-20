package bhargav.marsonia.s301108254.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bhargav.marsonia.s301108254.R;

public class BhargavFragmentMyPatient extends Fragment {
    public BhargavFragmentMyPatient() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bhargav_my_patient_list, container, false);
        return view;

    }

}