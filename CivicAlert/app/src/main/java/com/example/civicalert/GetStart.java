package com.example.civicalert;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GetStart extends AppCompatActivity {
Button userloginbtn,adminloginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_start);
        init();
        // Use new Handler method
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(GetStart.this, userlogin.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 8000); // 8 seconds delay

    }
    void init(){
        userloginbtn=findViewById(R.id.userloginbtn);
        adminloginbtn=findViewById(R.id.adminloginbtn);
    }
}