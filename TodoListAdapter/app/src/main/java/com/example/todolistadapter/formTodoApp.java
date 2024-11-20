package com.example.todolistadapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class formTodoApp extends AppCompatActivity {
  EditText taskName,taskEmploye,task,taskDate,taskDescription;
  Button btnPending,btnComplete;
  ListView
  ArrayList<Todo> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_todo_app);
        init();

        String taskname =taskName.getText().toString();
        String taskemploye =taskName.getText().toString();
        String task =taskName.getText().toString();
        String taskdate =taskName.getText().toString();
        String taskdesc =taskName.getText().toString();

 data.add(new Todo(taskname,taskemploye,task,taskdate,taskdesc));

        btnPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });


    }
    void init(){
        taskName=findViewById(R.id.taskName);
        taskEmploye=findViewById(R.id.taskEmploye);
        task=findViewById(R.id.task);
        taskDate=findViewById(R.id.taskDate);
        taskDescription=findViewById(R.id.taskDescription);
        btnPending=findViewById(R.id.btnPending);
        btnComplete=findViewById(R.id.btnComplete);
    }
}