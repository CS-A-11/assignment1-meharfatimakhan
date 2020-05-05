package com.example.eduguide.ui.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eduguide.R;
import com.example.eduguide.ui.documents.Document;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private DatabaseReference mDatabase;

    RecyclerView universityRecycler;
    UniversityAdapter adapterUniversity;
    private HomeViewModel homeViewModel;
    View root;
    ArrayList<University> universityList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        initList();
       // mDatabase = FirebaseDatabase.getInstance().getReference();
        return root;
    }

   /* private void writeNewUniversity(String uniID, String universityName, String picture, String location) {
        University universityObject = new University(uniID,universityName,picture,location);
        mDatabase.child("university").child(uniID).setValue(universityObject);
    }*/
    private void initList(){
        //Uri path = Uri.parse("android.resource://com.example.eduguide"+"/drawable/me");
        University uni1 = new University("1","LUMS","https://www.brecorder.com/wp-content/uploads/2020/01/LUMS.jpg","Lahore");
      //  writeNewUniversity("1","LUMS","https://www.brecorder.com/wp-content/uploads/2020/01/LUMS.jpg","Lahore");
        universityList.add(uni1);
        University uni2 = new University("2","UET","https://i.ytimg.com/vi/qH6Ce54JcDI/maxresdefault.jpg","Lahore");
        //writeNewUniversity("2","UET","https://i.ytimg.com/vi/qH6Ce54JcDI/maxresdefault.jpg","Lahore");
        universityList.add(uni2);
        University uni3 = new University("3","UCP","https://www.ucp.edu.pk/inc/uploads/2017/04/ucp-2.jpg","Lahore");
        //writeNewUniversity("3","UCP","https://www.ucp.edu.pk/inc/uploads/2017/04/ucp-2.jpg","Lahore");
        universityList.add(uni3);
        University uni4 = new University("4","FAST","https://media-exp1.licdn.com/dms/image/C511BAQGaVGUY_H6L2Q/company-background_10000/0?e=2159024400&v=beta&t=P3WLsJ7MoU0Mm_SV8RuQiYj9m64zPdrTFgX3ZBCUqqs","Lahore");
      //  writeNewUniversity("4","FAST","https://media-exp1.licdn.com/dms/image/C511BAQGaVGUY_H6L2Q/company-background_10000/0?e=2159024400&v=beta&t=P3WLsJ7MoU0Mm_SV8RuQiYj9m64zPdrTFgX3ZBCUqqs","Lahore");
        universityList.add(uni4);
        initRecyclerView();
    }

    private void initRecyclerView(){
        universityRecycler = root.findViewById(R.id.uniRecycler);
        adapterUniversity = new UniversityAdapter(getActivity(),universityList);
        universityRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
        universityRecycler.setAdapter(adapterUniversity);
    }
}
