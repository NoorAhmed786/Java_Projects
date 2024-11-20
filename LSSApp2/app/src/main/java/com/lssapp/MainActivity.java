package com.lssapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> std_name = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ListView student_name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        store_name();
        student_name = findViewById(R.id.student_name);

        for(int i = 0;i<std_name.size();i++)
        {
            if(i%2==0)
            {
                name.add(std_name.get(i));
            }
        }

        ArrayAdapter<String> std_Adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,name);
        student_name.setAdapter(std_Adapter);

        student_name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "AOA, "+name.get(i), Toast.LENGTH_SHORT).show();
            }
        });


    }

    void store_name()
    {
        std_name.add("Noor");
        std_name.add("Saba");
        std_name.add("Samama");
        std_name.add("Hafeez");
        std_name.add("Rizwan");
        std_name.add("Basit");
        std_name.add("Ali");
        std_name.add("Saboor");
        std_name.add("Sitra");
    }

}