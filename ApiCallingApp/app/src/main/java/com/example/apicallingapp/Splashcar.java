package com.example.apicallingapp;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Splashcar extends AppCompatActivity {
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashcar);

        imageView = findViewById(R.id.logocar);
        textView = findViewById(R.id.cartext);

//        // Fade in animation for the TextView
//        ObjectAnimator animator3 = ObjectAnimator.ofFloat(textView, "alpha", 0f, 1f);
//        animator3.setDuration(3000); // 3 seconds duration
//        animator3.setInterpolator(new AccelerateInterpolator());
//        animator3.start();
//
//        // Translation animation for the ImageView
//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "translationX", 500f, 0f);
//        animator1.setDuration(3000); // 3 seconds duration
//        animator1.setInterpolator(new AccelerateInterpolator());
//        animator1.start();

        // Use new Handler method
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splashcar.this, Signup.class);
                startActivity(intent);
                finish();
            }
        }, 8000); // 8 seconds delay
    }
}
