package com.example.fitnessapp;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
     Button logobtn;
     EditText edtname,edtemail;
     String Name,Email;
     TextView logintext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();


        // Create ObjectAnimators for each TextView
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(logintext, "translationY", -500f, 0f);
        animator1.setDuration(3000); // 3 seconds duration
        animator1.setInterpolator(new AccelerateInterpolator());
        animator1.start(); // Start animation for textLogo1

        logobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name=edtname.getText().toString();
                Email=edtemail.getText().toString();

                Intent next;
                next = new Intent(MainActivity.this, dashboard.class);
                next.putExtra("name",Name);
                startActivity(next);

            }


        });



    }

    void  init(){
        logobtn=findViewById(R.id.logbtn);
        edtname=findViewById(R.id.name);
        edtemail=findViewById(R.id.email);
        logintext=findViewById(R.id.logintext);
    }
}