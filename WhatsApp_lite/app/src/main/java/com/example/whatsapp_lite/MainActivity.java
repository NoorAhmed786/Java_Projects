package com.example.whatsapp_lite;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  RecyclerView recyclerView;
  ArrayList<WhatsClass> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        WhatsAdapter adapter = new WhatsAdapter(this,data);
        recyclerView.setAdapter(adapter);
        data.add( new WhatsClass(R.drawable.men,"Ali","comes tommorro"));
        data.add( new WhatsClass(R.drawable.content1,"Ali","comes tommorro"));
        data.add( new WhatsClass(R.drawable.content2,"Laiba","comes tommorro"));
        data.add( new WhatsClass(R.drawable.content3,"hassan","comes tommorro"));
        data.add( new WhatsClass(R.drawable.content5,"Noor","comes tommorro"));
        data.add( new WhatsClass(R.drawable.content6,"taha","comes tommorro"));
        data.add( new WhatsClass(R.drawable.men,"zaheer","comes tommorro"));
        data.add( new WhatsClass(R.drawable.content5,"zafar","comes tommorro"));
        data.add( new WhatsClass(R.drawable.content1,"merub","comes tommorro"));
        data.add( new WhatsClass(R.drawable.content6,"Ali","comes tommorro"));
        data.add( new WhatsClass(R.drawable.content2,"tutor","comes tommorro"));

    }

    void  init(){
        recyclerView=findViewById(R.id.recyclerview);
    }
}