package com.example.mediaapp;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    VideoView view;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        view=findViewById(R.id.vedioview);

        String vpath = "android.resource://"+getPackageName()+"/raw/stich.mp4";
//        third method vedio play
//        String onlinevedio ="https://www.pexels.com/video/person-choosing-clothes-8322525/";

        Uri vedioUri =Uri.parse(vpath);
//        Uri onvedio =Uri.parse(onlinevedio);


//  first one is path method vedio play

//        view.setVideoPath(vpath);


//        second is URI method vedio play
        view.setVideoURI(vedioUri);

        view.start();

//        media controller to control vedio btn
        MediaController mediaController = new MediaController(this);
        view.setMediaController(mediaController);

//        it control play and pause button
        mediaController.setAnchorView(view);


    }
}