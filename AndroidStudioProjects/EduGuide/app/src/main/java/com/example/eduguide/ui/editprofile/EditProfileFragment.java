package com.example.eduguide.ui.editprofile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.eduguide.R;
import com.example.eduguide.ui.editprofile.EditProfileViewModel;

public class EditProfileFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private EditProfileViewModel editProfileViewModel;
    String[] universities = { "Select University","LUMS", "FAST-NUCES", "UET", "COMSATS", "PUCIT","UET" };
    String[] departments = { "Select Department","Computer Science", "Electrical Engineering", "Civil Engineering", "Business Administration"};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        editProfileViewModel =
                ViewModelProviders.of(this).get(EditProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_editprofile, container, false);
        final EditText editName = root.findViewById(R.id.editName);
        editProfileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                editName.setText(s);
            }
        });

        Spinner spinUniv = (Spinner) root.findViewById(R.id.universityName);
        ArrayAdapter<String> universityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, universities);
        universityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinUniv.setAdapter(universityAdapter);

        spinUniv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getActivity(), "Selected University: "+ universities[position] ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinDept = (Spinner) root.findViewById(R.id.departmentName);
        ArrayAdapter<String> departmentAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, departments);
        departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDept.setAdapter(departmentAdapter);
        //spinDept.setOnItemSelectedListener(this);
        spinDept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getActivity(), "Selected Department: "+ departments[position] ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button addButton= root.findViewById(R.id.addPhoto);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(), "Photo added!" ,Toast.LENGTH_SHORT).show();
            }
        });
        Button removeButton= root.findViewById(R.id.removePhoto);
        removeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(), "Photo removed!" ,Toast.LENGTH_SHORT).show();
            }
        });
        Button applyButton= root.findViewById(R.id.saveButton);
        applyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(), "Changes Saved!" ,Toast.LENGTH_SHORT).show();
            }
        });
        return root;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
