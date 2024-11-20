package com.example.todolist;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class detail extends AppCompatActivity {
    Button btnform;
    ListView std_listview;
    ArrayList<String> Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        btnform = findViewById(R.id.btnform);
        std_listview = findViewById(R.id.std_list);
        show_data();






    }
    void show_data()
    {
        Intent std_intent = getIntent();
        Name = std_intent.getStringArrayListExtra("std_data");

        if(Name==null)
        {
            Name = new ArrayList<>();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,Name);
        std_listview.setAdapter(adapter);

        btnform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        std_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /** @noinspection deprecation*/
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Name.remove(i);
//
                Intent intent = new Intent(detail.this, update.class);
                intent.putExtra("item_value", Name.get(i));
                intent.putExtra("item_position", i);
                startActivityForResult(intent, 100);
                adapter.notifyDataSetChanged();

            }
        });
    }
}