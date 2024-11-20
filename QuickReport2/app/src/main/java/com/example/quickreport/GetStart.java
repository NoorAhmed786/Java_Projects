package com.example.quickreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GetStart extends AppCompatActivity {
    Button adminbtn,userbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_start);
        init();

        userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetStart.this, UserLogin.class);
                startActivity(intent);
                finish();
            }
        });

        adminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(GetStart.this, AdminLogin.class);
                startActivity(intent);
                finish();

            }
        });





    }
        void init(){
            adminbtn=findViewById(R.id.adminloginbtn);
            userbtn=findViewById(R.id.userloginbtn);
        }
}