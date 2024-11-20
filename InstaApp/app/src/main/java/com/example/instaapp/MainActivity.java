package com.example.instaapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnnavview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        btnnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int i = item.getItemId();
                if(i== R.id.home){
                    setFragment(new HomeFragment(),0);

                } else if (i==R.id.search) {
                    setFragment(new SearchFragment(),1);

                } else if (i==R.id.add) {
                    setFragment(new AddFragment(),2);

                } else if (i==R.id.reels) {
                    setFragment(new ReelFragment(),3);

                } else if (i==R.id.profile) {
                    setFragment(new ProfileFragment(),4);

                }
                return true;
            }
        });

    }
    void init(){
        btnnavview=findViewById(R.id.btmNavView);
    }
    void setFragment(Fragment fragment,int value){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        if(value==0){
            ft.add(R.id.framelayout,fragment);
        }else{
            ft.add(R.id.framelayout,fragment);
        }
        ft.commit();
    }
}