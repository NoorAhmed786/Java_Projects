package com.example.instaapp;



import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;


public class SearchFragment extends Fragment {
   Spinner spinner;
    ArrayList<String> Subject;
    Context context;

    public SearchFragment(Spinner spinner, ArrayList<String> subject, Context context) {
        this.spinner = spinner;
        Subject = subject;
        this.context = context;
    }

    public SearchFragment(int contentLayoutId, Spinner spinner, ArrayList<String> subject, Context context) {
        super(contentLayoutId);
        this.spinner = spinner;
        Subject = subject;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_search, container, false);
        //SPINNER
        spinner = v.findViewById(R.id.spinner);
        Subject.add("Computer Science");
        Subject.add("Software Engineering");
        Subject.add("BBA");
        Subject.add("Education");
        Subject.add("AI");

        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<>(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Subject);
        spinner.setAdapter(subjectAdapter);

        return v;
    }
}