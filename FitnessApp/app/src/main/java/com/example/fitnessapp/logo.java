package com.example.fitnessapp;

import static com.example.fitnessapp.R.*;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class logo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logo);

        // Find the TextView elements
        TextView textLogo1 = findViewById(R.id.textlogo1);
        TextView textLogo2 = findViewById(R.id.textlogo2);
        ImageView logoImg = findViewById(id.logo1);

        // Create ObjectAnimators for each TextView
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(textLogo1, "translationX", -500f, 0f);
        animator1.setDuration(3000); // 3 seconds duration
        animator1.setInterpolator(new AccelerateInterpolator());
        animator1.start(); // Start animation for textLogo1

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(textLogo2, "translationX", 500f, 0f);
        animator2.setDuration(3000); // 3 seconds duration
        animator2.setInterpolator(new AccelerateInterpolator());
//        animator2.setStartDelay(1500); // Delay the start of the second animation
        animator2.start(); // Start animation for textLogo2

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(logoImg, "alpha", 0f, 1f);
        animator3.setDuration(3000); // 3 seconds duration
        animator3.setInterpolator(new AccelerateInterpolator());
        animator3.start(); // Start animation for textLogo1



        // Delay the transition to the next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent next = new Intent(logo.this, MainActivity.class);
                startActivity(next);
                finish();
            }
        }, 8000); // 8 seconds delay
    }
}
