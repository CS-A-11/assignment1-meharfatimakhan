package com.example.eduguide.ui.home;

import android.os.Bundle;
import com.example.eduguide.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CourseClass extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
