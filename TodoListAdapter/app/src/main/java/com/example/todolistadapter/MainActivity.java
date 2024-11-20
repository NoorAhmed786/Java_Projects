package com.example.todolistadapter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  EditText taskName,taskEmploye,task,taskDate,taskDescription;
  Button btnComplete,btnPending;
  ArrayList<Todo> data =new ArrayList<>();
  ListView listView;
  RelativeLayout bcakcolor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();

        String taskname =taskName.getText().toString();
        String taskemploye =taskEmploye.getText().toString();
        String Task =task.getText().toString();
        String TaskDate =taskDate.getText().toString();
        String taskdesc =taskDescription.getText().toString();

        data.add(new Todo(taskname,taskemploye,Task,TaskDate,taskdesc));

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bcakcolor.setBackgroundResource(R.color.greeen);
            }
        });
        btnPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bcakcolor.setBackgroundResource(R.color.red);
            }
        });


    }
    void init(){
        taskName=findViewById(R.id.taskName);
        taskEmploye=findViewById(R.id.taskEmploye);
        task=findViewById(R.id.task);
        taskDate=findViewById(R.id.taskDate);
        taskDescription=findViewById(R.id.taskDescription);
        btnComplete=findViewById(R.id.btnComplete);
        btnPending=findViewById(R.id.btnPending);
        listView=findViewById(R.id.listView);

    }
}