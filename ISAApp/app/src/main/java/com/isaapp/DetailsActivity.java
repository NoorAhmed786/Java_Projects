package com.isaapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {

    String Name,Email,Semester;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);

        Intent icontent = getIntent();
        Name = icontent.getStringExtra("name");
        Email = icontent.getStringExtra("email");
        Semester = icontent.getStringExtra("semester");

        TextView test;

        test = findViewById(R.id.details);

        test.setText("Name : "+Name+"\nEmail : "+Email+"\nSemester : "+Semester);
    }
}