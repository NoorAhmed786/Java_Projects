package com.manuapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnprofile,btnabout,btnproject;

        btnprofile = findViewById(R.id.btnprofile);
        btnabout = findViewById(R.id.btnabout);
        btnproject = findViewById(R.id.btnproject);

//        setButtonClickListener(btnprofile, ProfileActivity.class);
//        setButtonClickListener(btnabout, AboutActivity.class);
//        setButtonClickListener(btnproject, ProjectActivity.class);

//        btnprofile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent next;
//                next = new Intent(MainActivity.this,ProfileActivity.class);
//                startActivity(next);
//            }
//        });
//
//        btnabout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent next;
//                next = new Intent(MainActivity.this,AboutActivity.class);
//                startActivity(next);
//            }
//        });
//
//        btnproject.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent next;
//                next = new Intent(MainActivity.this,ProfileActivity.class);
//                startActivity(next);
//            }
//        });


    }

    private void setButtonClickListener(Button button, Class<?> activityClass) {
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, activityClass);
            startActivity(intent);
        });
    }

    public void next(View view)
    {
        Button currbtn = (Button) view;
        Intent next;
        btn = currbtn.getText().toString();
        if(btn.equals("Profile"))
        {
            next = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(next);
        }
        else if(btn.equals("About"))
        {
            next = new Intent(MainActivity.this,AboutActivity.class);
            startActivity(next);
        }
        else
        {
            next = new Intent(MainActivity.this,ProjectActivity.class);
            startActivity(next);
        }
    }
}