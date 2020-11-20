package bhargav.marsonia.s301108254.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import bhargav.marsonia.s301108254.R;
import bhargav.marsonia.s301108254.db.DatabaseHandler;
import bhargav.marsonia.s301108254.model.BhargavPatient;

public class BhargavFragmentAddPatient extends Fragment {

    public String department;
    EditText first_name, last_name;
    public BhargavFragmentAddPatient() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bhargav_add_patient, container, false);
        first_name = (EditText) v.findViewById(R.id.bhargav_patient_first_name);
        last_name = (EditText) v.findViewById(R.id.bhargav_patient_last_name);
        Button submit = v.findViewById(R.id.bhargav_add_patient);
        Spinner spinner = v.findViewById(R.id.bhargav_department_list);
        BaseAdapter adapter = new ArrayAdapter(getActivity(),  android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.departmentList));
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                department = getResources().getStringArray(R.array.departmentList)[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(first_name.getText().toString().isEmpty() && last_name.getText().toString().isEmpty() && department.isEmpty()){
                    Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else{
                    BhargavPatient patient = new BhargavPatient();
                    patient.setFirst_name(first_name.getText().toString());
                    patient.setLast_name(last_name.getText().toString());
                    patient.setDepartment_name(department);
                    DatabaseHandler handler = new DatabaseHandler(getContext());
                    handler.addPatient(patient);
                    handler.getPatient();
                }

            }
        });
        return v;
    }

}