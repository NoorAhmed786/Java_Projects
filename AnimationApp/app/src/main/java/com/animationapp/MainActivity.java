package com.animationapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    Button btnzoom,btnblink,btnrotate,btnslide,btnmove,btnfade,btnstop;
    Animation loadanimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        btnblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
                logo.startAnimation(loadanimation);
            }
        });
        btnfade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
                logo.startAnimation(loadanimation);
            }
        });
        btnmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                logo.startAnimation(loadanimation);
            }
        });
        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                logo.startAnimation(loadanimation);
            }
        });
        btnslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
                logo.startAnimation(loadanimation);
            }
        });
        btnzoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
                logo.startAnimation(loadanimation);
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logo.clearAnimation();
            }
        });

    }
    void init()
    {
        logo = findViewById(R.id.logo);
        btnzoom = findViewById(R.id.BTNzoom);
        btnblink = findViewById(R.id.BTNblink);
        btnfade = findViewById(R.id.BTNfade);
        btnmove = findViewById(R.id.BTNmove);
        btnrotate = findViewById(R.id.BTNrotate);
        btnslide = findViewById(R.id.BTNslide);
        btnstop = findViewById(R.id.BTNstop);
    }
}
