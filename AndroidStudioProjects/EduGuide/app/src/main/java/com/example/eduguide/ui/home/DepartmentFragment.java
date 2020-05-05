package com.example.eduguide.ui.home;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eduguide.R;
import java.util.*;

public class DepartmentFragment extends Fragment {
    RecyclerView departmentRecycler;
    DepartmentAdapter departmentAdapter;
    View root;
    ArrayList<Department> departmentList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_department, container, false);
        initList();
        return root;
    }

    private void initList(){
        Department dep1 = new Department("1","Computer Science","1","https://cdn.neow.in/news/images/uploaded/2018/08/1535719249_computer_science_story.jpg");
        departmentList.add(dep1);
        Department dep2 = new Department("2","Electrical Engineering","1","https://inteng-storage.s3.amazonaws.com/img/iea/y5wWQR9VGX/sizes/electricalengineeringmain11_resize_md.jpg");
        departmentList.add(dep2);
        Department dep3 = new Department("3","Civil Engineering","2","https://inteng-storage.s3.amazonaws.com/img/iea/bM6A1xZR67/sizes/civil-engineering_resize_md.jpg");
        departmentList.add(dep3);
        Department dep4 = new Department("4","Management Sciences","4","https://mbastudiespk.files.wordpress.com/2016/04/accounting-and-finance-images.jpg");
        departmentList.add(dep4);

        initRecyclerView();
    }

    private void initRecyclerView(){
        departmentRecycler = root.findViewById(R.id.deptRecycler);
        departmentAdapter = new DepartmentAdapter(getActivity(),departmentList);
        departmentRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
        departmentRecycler.setAdapter(departmentAdapter);
    }
}

