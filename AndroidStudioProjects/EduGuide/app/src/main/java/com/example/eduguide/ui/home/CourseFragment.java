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

public class CourseFragment extends Fragment {
    RecyclerView courseRecycler;
    CourseAdapter courseAdapter;
    View root;
    ArrayList<Course> courseList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_course, container, false);
        initList();
        return root;
    }

    private void initList(){
        Course course1 = new Course("1","Architecture","321","1231","https://www.edx.org/sites/default/files/course/image/promoted/mitx_6.004.2x_378x225.jpg");
        courseList.add(course1);
        Course course2 = new Course("2","Software Engineering","412","423","https://static.timesofisrael.com/blogs/uploads/2019/10/bhanu.jpg");
        courseList.add(course2);
        Course course3 = new Course("3","Computer Vision","412","432","https://i.pcmag.com/imagery/articles/061CyMCZV6G2sXUmreKHvXS-1.fit_scale.size_2698x1517.v1581020108.jpg");
        courseList.add(course3);
        Course course4 = new Course("4","Web Development","12","43","https://www.umbrellaconsultants.com/files/resources/outer-banks-web-development-hosting.jpg");
        courseList.add(course4);

        initRecyclerView();
    }

    private void initRecyclerView(){
        courseRecycler = root.findViewById(R.id.courseRecycler);
        courseAdapter = new CourseAdapter(getActivity(),courseList);
        courseRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
        courseRecycler.setAdapter(courseAdapter);
    }
}

