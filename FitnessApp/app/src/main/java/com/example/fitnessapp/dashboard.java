package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dashboard extends AppCompatActivity {
     String Name;
     ImageView img1;
    TextView test,bmi,youga,tips,meditation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        init();

        Intent dash =getIntent();
        Name = dash.getStringExtra("name");
        test.setText(Name);

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next;
                next = new Intent(dashboard.this,BMI.class);
                startActivity(next);
            }
        });
        meditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next;
                next = new Intent(dashboard.this,meditation.class);
                startActivity(next);
            }
        });


    }
    void init(){
        test =findViewById(R.id.customer);
        img1 = findViewById(R.id.img1);
        bmi=findViewById(R.id.bmi);
        meditation=findViewById(R.id.medi);
    }
}