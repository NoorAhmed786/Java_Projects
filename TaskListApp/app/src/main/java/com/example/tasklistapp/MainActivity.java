package com.example.tasklistapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> taskList = new ArrayList<>();
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        EditText inputTask = findViewById(R.id.inputTask);
        Button addTaskButton = findViewById(R.id.addTaskButton);

        adapter = new TaskAdapter(taskList, (position, task) -> {
            // Update task if needed
            taskList.set(position, task);
            adapter.notifyItemChanged(position);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        addTaskButton.setOnClickListener(v -> {
            String taskName = inputTask.getText().toString();
            if (!taskName.isEmpty()) {
                taskList.add(new Task(taskName, false));
                adapter.notifyItemInserted(taskList.size() - 1);
                inputTask.setText("");
            }
        });
    }
}


