package com.example.todolistadapter;

import android.app.TaskInfo;
import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kotlinx.coroutines.scheduling.Task;

public class TodoAdapter extends BaseAdapter {
   private LayoutInflater inflater;
    ArrayList<Todo> todo_data;



    @Override
    public int getCount() {
        return todo_data.size();
    }

    @Override
    public Object getItem(int position) {
        return todo_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View listview, ViewGroup viewlist) {
        TaskViewHolder holder;
        if(listview== null){
             listview=inflater.inflate(R.layout.activity_main,viewlist,false);
             holder = new TaskViewHolder();
             holder.task_name=listview.findViewById(R.id.taskName);
             holder.task_employee=listview.findViewById(R.id.taskEmploye);
             holder.tas_k=listview.findViewById(R.id.task);
             holder.task_date=listview.findViewById(R.id.taskDate);
             holder.task_desc=listview.findViewById(R.id.taskDescription);
             listview.setTag(holder);
        }else {
            holder=(TaskViewHolder)listview.getTag();
        }
        Todo task = todo_data.get(position);
        holder.task_name.setText(task.getTitle());
        holder.task_employee.setText(task.getTitle());
        holder.tas_k.setText(task.getTitle());
        holder.task_date.setText(task.getTitle());
        holder.task_desc.setText(task.getTitle());




        return listview;

    }

    static class TaskViewHolder{
        TextView task_name,task_employee,tas_k,task_date,task_desc;
    }


}
