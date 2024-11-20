package com.example.fb_lite;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FbSplash extends AppCompatActivity {
    ImageView fb_spalsh;
//    Animation loadanimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fb_splash2);

//                loadanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
//        fb_spalsh.startAnimation(loadanimation);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(fb_spalsh, "alpha", 0f, 1f);
        animator3.setDuration(3000); // 3 seconds duration
        animator3.setInterpolator(new AccelerateInterpolator());
        animator3.start(); // Start animation for textLogo1


        fb_spalsh=findViewById(R.id.fb_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FbSplash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },8000);

    }
}