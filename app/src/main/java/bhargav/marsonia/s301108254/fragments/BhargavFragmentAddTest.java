package bhargav.marsonia.s301108254.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import bhargav.marsonia.s301108254.R;
import bhargav.marsonia.s301108254.db.DatabaseHandler;
import bhargav.marsonia.s301108254.model.BhargavPatient;


public class BhargavFragmentAddTest extends Fragment {
    TextView date;
    Button submit;
    Spinner patient_data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_bhargav_add_test, container, false);
        date = view.findViewById(R.id.bhargav_test_date);
        submit = view.findViewById(R.id.bhargav_add_test);
        patient_data = view.findViewById(R.id.bhargav_patient_list);
        DatabaseHandler handler = new DatabaseHandler(getActivity());
        BaseAdapter adapter = new ArrayAdapter(getActivity(),  android.R.layout.simple_spinner_item, handler.getPatient());
        patient_data.setAdapter(adapter);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(date);
            }
        });
        return view;
    }
    void showDatePicker(final TextView textView){
        final Calendar c = Calendar.getInstance();
        int  mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        textView.setText((monthOfYear + 1)+"/"+dayOfMonth + "/"+ year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}