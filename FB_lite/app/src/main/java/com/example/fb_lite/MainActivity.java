package com.example.fb_lite;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ImageView add_content,search,menu;
    RecyclerView recyclerView;
    RecyclerView recyclerUser;
    ArrayList<Tour> data = new ArrayList<>();
    ArrayList<UserContent> userData = new ArrayList<>();
    ArrayList<String> Department =new ArrayList<>();
    AutoCompleteTextView txtauto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

//         data store in array
        data.add(new Tour(R.drawable.medi4,"Cool guy"));
        data.add(new Tour(R.drawable.medi2,"Carry"));
        data.add(new Tour(R.drawable.medi5,"FoodLover"));
        data.add(new Tour(R.drawable.medi3,"Laiba"));
        data.add(new Tour(R.drawable.content5,"scientist"));
        data.add(new Tour(R.drawable.medi,"Samina"));
        data.add(new Tour(R.drawable.content4,"Ahmed"));

        // adapter data transfer from array to temp layout then set the main layout

        TourAdapter tourAdapter = new TourAdapter(this,data);
        recyclerView.setAdapter(tourAdapter);

//set the layout where nd how do u like the layout u want
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerUser.setLayoutManager(layoutManager1);
        userData.add(new UserContent(R.drawable.content1,R.drawable.content1,"Samina","My profile"));
        userData.add(new UserContent(R.drawable.medi,R.drawable.medi,"Samama","waterfall"));
        userData.add(new UserContent(R.drawable.content2,R.drawable.content2,"Carry","Cat lovers"));
        userData.add(new UserContent(R.drawable.content3,R.drawable.content3,"Bakelitch","Shot day"));
        userData.add(new UserContent(R.drawable.content4,R.drawable.content4,"Ahmad","today's situation"));
        userData.add(new UserContent(R.drawable.content5,R.drawable.content5,"Scientist","Astournote"));
        userData.add(new UserContent(R.drawable.content6,R.drawable.content6,"Cool","Shapater"));
        userData.add(new UserContent(R.drawable.content7,R.drawable.content7,"Spounge ","Cartoon lovers"));
        userData.add(new UserContent(R.drawable.medi5,R.drawable.medi5,"Food ","Food lovers"));

        UserContAdapter contAdapter =new UserContAdapter(this,userData);
        recyclerUser.setAdapter(contAdapter);

        //AUTO COMPLETE TEXT VIEW
        Department.add("Ahmed");
        Department.add("Samina");
        Department.add("Cool");
        Department.add("Food");
        Department.add("Lover");
        Department.add("Spounge");
        Department.add("Carry");
        Department.add("Samama");
        Department.add("Medical");
        ArrayAdapter<String> deptAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,Department);
        txtauto.setAdapter(deptAdapter);
        txtauto.setThreshold(1);




    }
    void  init()
    {
        add_content=findViewById(R.id.add_content);
        search=findViewById(R.id.search);
        menu=findViewById(R.id.menu);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerUser=findViewById(R.id.contentRecycle);
        txtauto = findViewById(R.id.txtauto);

    }
}