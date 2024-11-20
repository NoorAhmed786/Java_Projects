package com.example.fitnessapp;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class meditation extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    TextView meditext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);


        // Create ObjectAnimators for each TextView
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(meditext, "translationY", -500f, 0f);
        animator1.setDuration(3000); // 3 seconds duration
        animator1.setInterpolator(new AccelerateInterpolator());
        animator1.start(); // Start animation for textLogo1

        // Initialize the MediaPlayer with the audio resource
        mediaPlayer = MediaPlayer.create(this, R.raw.bird);

        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start playing the audio
                mediaPlayer.start();
            }
        });

        Button stopButton = findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Stop and release the MediaPlayer
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release MediaPlayer resources when activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
