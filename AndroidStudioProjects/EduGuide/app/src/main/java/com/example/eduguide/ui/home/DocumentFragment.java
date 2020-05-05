package com.example.eduguide.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eduguide.R;
import com.example.eduguide.ui.documents.Document;


import java.util.*;

public class DocumentFragment extends Fragment {
    DocumentAdapter adapterMyDocAssignment;
    DocumentAdapter adapterMyDocQuiz;
    DocumentAdapter adapterMyDocPP;
    DocumentAdapter adapterMyOtherMaterial;
    RecyclerView recyclerViewAssignment;
    RecyclerView recyclerViewQuiz;
    RecyclerView recyclerViewPP;
    RecyclerView recyclerViewOtherMaterial;
    View root;
    ArrayList<Document> documentList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.document_fragment, container, false);

        initList();
        return root;
    }

    private void initList(){
        Document myDoc1 = new Document("1","meharfatima","Quiz","Quiz 2 2019","443");
        documentList.add(myDoc1);
        Document myDoc2 = new Document("2","meharfatima","Quiz","Quiz 1 2020","443");
        documentList.add(myDoc2);
        Document myDoc3 = new Document("3","meharfatima","Assignment","Assignment 1 2020","443");
        documentList.add(myDoc3);
        Document myDoc4 = new Document("4","meharfatima","Assignment","Assignment 2 2018","443");
        documentList.add(myDoc4);
        Document myDoc5 = new Document("5","meharfatima","Past Paper","Mid 1 2018","443");
        documentList.add(myDoc5);
        Document myDoc6 = new Document("6","meharfatima","Past Paper","Final 2018","443");
        documentList.add(myDoc6);
        Document myDoc7 = new Document("7","meharfatima","Other Material","Notes 2020","443");
        documentList.add(myDoc7);
        Document myDoc8 = new Document("8","meharfatima","Other Material","Notes 2018","443");
        documentList.add(myDoc8);

        initRecyclerView();
    }
    private void initRecyclerView() {
        ArrayList<Document> myDocA = new ArrayList<>();
        ArrayList<Document> myDocQ = new ArrayList<>();
        ArrayList<Document> myDocP = new ArrayList<>();
        ArrayList<Document> myDocO = new ArrayList<>();
        Document docObj;
        recyclerViewAssignment = root.findViewById(R.id.assignmentRecycler);
        recyclerViewQuiz = root.findViewById(R.id.quizRecycler);
        recyclerViewPP = root.findViewById(R.id.ppRecycler);
        recyclerViewOtherMaterial = root.findViewById(R.id.otherMRecycler);
        for (int i = 0; i < documentList.size();i++){
            if (documentList.get(i).getDocType().equals("Quiz")) {
                docObj = documentList.get(i);
                myDocQ.add(docObj);
                adapterMyDocQuiz = new DocumentAdapter(getActivity(),myDocQ);
            }
            else if (documentList.get(i).getDocType().equals("Assignment")){
                docObj = documentList.get(i);
                myDocA.add(docObj);
                adapterMyDocAssignment = new DocumentAdapter(getActivity(),myDocA);
            }
            else if (documentList.get(i).getDocType().equals("Past Paper")){
                docObj = documentList.get(i);
                myDocP.add(docObj);
                adapterMyDocPP = new DocumentAdapter(getActivity(),myDocP);
            }
            else if (documentList.get(i).getDocType().equals("Other Material")){
                docObj = documentList.get(i);
                myDocO.add(docObj);
                adapterMyOtherMaterial = new DocumentAdapter(getActivity(),myDocO);
            }
        }
        recyclerViewPP.setAdapter(adapterMyDocPP);
        recyclerViewPP.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewAssignment.setAdapter(adapterMyDocAssignment);
        recyclerViewAssignment.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewQuiz.setAdapter(adapterMyDocQuiz);
        recyclerViewQuiz.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewOtherMaterial.setAdapter(adapterMyOtherMaterial);
        recyclerViewOtherMaterial.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
