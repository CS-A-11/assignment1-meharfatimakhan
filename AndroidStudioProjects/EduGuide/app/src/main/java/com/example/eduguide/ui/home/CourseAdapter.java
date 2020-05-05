package com.example.eduguide.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.eduguide.R;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    ArrayList<Course> courseList;

    public CourseAdapter(Context context, ArrayList<Course> courseList){
        this.mContext=context;
        this.courseList = courseList;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item,parent,false);
        CourseAdapter.ViewHolder holder = new CourseAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Course course = courseList.get(position);
        holder.courseName.setText(course.getCourseName());

        if (course.getPicture() != null){
            Glide.with(mContext).asDrawable().load(course.getPicture()).into(holder.courseImage);
        }
        else{
            holder.courseImage.setImageResource(R.drawable.app_launcher);
        }
        holder.parentLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, DocumentClass.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView courseName;
        ImageView courseImage;
        CardView parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.thumbText);
            courseImage = itemView.findViewById(R.id.thumbImage);
            parentLayout = itemView.findViewById(R.id.itemThumb);
        }
    }
}
