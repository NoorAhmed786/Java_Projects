package com.example.quickreport;

public class UserFormData {
    String name, email, password;

    public UserFormData(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public UserFormData(){

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
