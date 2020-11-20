package bhargav.marsonia.s301108254.adapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import bhargav.marsonia.s301108254.R;
import  bhargav.marsonia.s301108254.model.BhargavPatientData;

public class BhargavMyPatientListAdapter extends ArrayAdapter {
    Activity context;
    List<BhargavPatientData> patientData;
    public BhargavMyPatientListAdapter(@NonNull Activity context, int resource, List<BhargavPatientData> patientData) {
        super(context, resource);
        this.context = context;
        this.patientData = patientData;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.bhargav_my_patient_list, null,true);
        TextView nurse_id = rowView.findViewById(R.id.bhargav_nurse_id);
        TextView room_no = rowView.findViewById(R.id.bhargav_room_no);
        TextView patient_name = rowView.findViewById(R.id.bhargav_patient_name);
        TextView department = rowView.findViewById(R.id.bhargav_department_name);
        nurse_id.setText(this.patientData.get(position).getNurse_ID());
        room_no.setText(this.patientData.get(position).getRoom_no());
        patient_name.setText(this.patientData.get(position).getPatient_name());
        department.setText(this.patientData.get(position).getDepartment_name());
        return rowView;

    };
}
