package com.example.tasklistapp;

public class Task {

        private String taskName;
        private boolean isCompleted;

        public Task(String taskName, boolean isCompleted) {
            this.taskName = taskName;
            this.isCompleted = isCompleted;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        public void setCompleted(boolean completed) {
            isCompleted = completed;
        }
    }


