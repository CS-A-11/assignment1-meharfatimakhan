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

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    ArrayList<University> universityList;

    public UniversityAdapter(Context context, ArrayList<University> universityList){
        this.mContext=context;
        this.universityList = universityList;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public UniversityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item,parent,false);
        UniversityAdapter.ViewHolder holder = new UniversityAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final University universities = universityList.get(position);
        holder.uniName.setText(universities.getUniversityName());

        if (universities.getPicture() != null){
            Glide.with(mContext).asDrawable().load(universities.getPicture()).into(holder.uniImage);
        }
        else{
            holder.uniImage.setImageResource(R.drawable.app_launcher);
        }

        holder.parentLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, DepartmentClass.class);
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
        return universityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView uniName;
        ImageView uniImage;
        CardView parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            uniName = itemView.findViewById(R.id.thumbText);
            uniImage = itemView.findViewById(R.id.thumbImage);
            parentLayout = itemView.findViewById(R.id.itemThumb);
        }
    }
}
