package com.form;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class logoActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logo2);

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent nex;
               nex =new Intent(logoActivity2.this,MainActivity.class);
               startActivity(nex);
               finish();
           }
       },8000);
    }

}