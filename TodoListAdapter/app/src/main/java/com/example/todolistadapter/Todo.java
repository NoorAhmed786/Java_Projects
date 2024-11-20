package com.example.todolistadapter;

public class Todo {
    String Taskname,Taskemploye,Taskasign,Taskdate,Taskdes;
    private int title;

    public Todo(String taskname, String taskemploye, String taskasign, String taskdate, String taskdes) {
        Taskname = taskname;
        Taskemploye = taskemploye;
        Taskasign = taskasign;
        Taskdate = taskdate;
        Taskdes = taskdes;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }
}
