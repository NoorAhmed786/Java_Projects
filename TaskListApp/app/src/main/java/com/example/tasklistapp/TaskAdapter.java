package com.example.tasklistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList;
    private OnTaskEditListener listener;

    public TaskAdapter(List<Task> taskList, OnTaskEditListener listener) {
        this.taskList = taskList;
        this.listener = listener;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.taskitem, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskEditText.setText(task.getTaskName());
        holder.taskCheckBox.setChecked(task.isCompleted());

        holder.taskCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.setCompleted(isChecked);
        });

        holder.taskEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                task.setTaskName(holder.taskEditText.getText().toString());
                listener.onTaskEdited(position, task);
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public EditText taskEditText;
        public CheckBox taskCheckBox;

        public TaskViewHolder(View itemView) {
            super(itemView);
            taskEditText = itemView.findViewById(R.id.taskEditText);
            taskCheckBox = itemView.findViewById(R.id.taskCheckBox);
        }
    }

    public interface OnTaskEditListener {
        void onTaskEdited(int position, Task task);
    }
}

