package com.example.whatsapp_lite;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {
ImageView Wtlogo;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);


        Wtlogo=findViewById(R.id.logo);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(Wtlogo, "alpha", 0f, 1f);
        animator3.setDuration(3000); // 3 seconds duration
        animator3.setInterpolator(new AccelerateInterpolator());
        animator3.start(); // Start animation for textLogo1

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },8000);
    }
}