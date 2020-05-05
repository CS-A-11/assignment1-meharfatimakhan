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

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    ArrayList<Department> departmentList;

    public DepartmentAdapter(Context context, ArrayList<Department> departmentList){
        this.mContext=context;
        this.departmentList = departmentList;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public DepartmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item,parent,false);
        DepartmentAdapter.ViewHolder holder = new DepartmentAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Department departments = departmentList.get(position);
        holder.deptName.setText(departments.getDeptName());

        if (departments.getPicture() != null){
            Glide.with(mContext).asDrawable().load(departments.getPicture()).into(holder.deptImage);
        }
        else{
            holder.deptImage.setImageResource(R.drawable.app_launcher);
        }
        holder.parentLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, CourseClass.class);
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
        return departmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView deptName;
        ImageView deptImage;
        CardView parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            deptName = itemView.findViewById(R.id.thumbText);
            deptImage = itemView.findViewById(R.id.thumbImage);
            parentLayout = itemView.findViewById(R.id.itemThumb);
        }
    }
}
