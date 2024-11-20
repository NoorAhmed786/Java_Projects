package com.example.civicalert;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {
ImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

     imageView=findViewById(R.id.logo2);

        // Fade in animation for the TextView
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "alpha", 0f, 1f);
        animator3.setDuration(3000); // 3 seconds duration
        animator3.setInterpolator(new AccelerateInterpolator());
        animator3.start();

    }
}