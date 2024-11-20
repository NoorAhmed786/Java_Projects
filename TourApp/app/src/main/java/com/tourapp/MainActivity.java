package com.tourapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView  recyclerView;
    ArrayList<Tour> data = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        data.add(new Tour(R.drawable.img1,"Karachi"));
        data.add(new Tour(R.drawable.img2,"Hyderabad"));
        data.add(new Tour(R.drawable.img3,"Larkhana"));
        data.add(new Tour(R.drawable.img4,"Rawalpindi"));
        data.add(new Tour(R.drawable.img5,"Lahore"));
        data.add(new Tour(R.drawable.img6,"Multan"));
        data.add(new Tour(R.drawable.img7,"Islamabad"));
        data.add(new Tour(R.drawable.img8,"Sukkar"));
        data.add(new Tour(R.drawable.img9,"Gilgit"));
        data.add(new Tour(R.drawable.img10,"Hunza"));

        TourAdapter tourAdapter = new TourAdapter(this,data);
        recyclerView.setAdapter(tourAdapter);


    }
}