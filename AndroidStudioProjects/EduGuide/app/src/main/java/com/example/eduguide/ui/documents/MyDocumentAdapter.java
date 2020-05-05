package com.example.eduguide.ui.documents;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eduguide.R;

import java.util.*;

public class MyDocumentAdapter extends RecyclerView.Adapter<MyDocumentAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    ArrayList<Document> documentList;

    public MyDocumentAdapter(Context context, ArrayList<Document> documentList){
        this.mContext=context;
        this.documentList = documentList;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public MyDocumentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_mydocumentitem,parent,false);
        MyDocumentAdapter.ViewHolder holder = new MyDocumentAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Document document = documentList.get(position);
        holder.docName.setText(document.getDocumentName());
    }

    @Override
    public int getItemCount() {
        return documentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView docName;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            docName = itemView.findViewById(R.id.doc);
            parentLayout = itemView.findViewById(R.id.itemMyDoc);
        }
    }
}
