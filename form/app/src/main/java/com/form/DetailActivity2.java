package com.form;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity2 extends AppCompatActivity {
    String Name,Email,Semester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail2);

        Intent icontent= getIntent();
       Name=icontent.getStringExtra("name");
       Email=icontent.getStringExtra("email");
       Semester=icontent.getStringExtra("semester");

        TextView test;
        test =findViewById(R.id.detail);
        test.setText("Name :"+ Name +"\nEmail :" +Email+"\nSemester :"+Semester);

    }
}