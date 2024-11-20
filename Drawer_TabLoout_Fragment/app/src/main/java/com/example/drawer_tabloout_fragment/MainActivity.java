package com.example.drawer_tabloout_fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();

        setSupportActionBar(toolbar);//for tollbar reference///

        ActionBarDrawerToggle studentActionBar=new ActionBarDrawerToggle(this,drawerLayout,
                R.string.Open_Student_Drawerlayout,
                R.string.close_Student_Drawerlayout);
        drawerLayout.addDrawerListener(studentActionBar);
        studentActionBar.syncState();

        setFragment(new Create_Fragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int i=item.getItemId();
                if (i==R.id.create){

                    Toast.makeText(MainActivity.this, "Create successfully", Toast.LENGTH_SHORT).show();
                } else if (i==R.id.delete) {
                    Toast.makeText(MainActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                } else if (i==R.id.read) {
                    Toast.makeText(MainActivity.this, "Read the content", Toast.LENGTH_SHORT).show();
                }

                     setFragment(new UpdateFragment());
                    Toast.makeText(MainActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            }
        });

    }

    void  init(){
        drawerLayout=findViewById(R.id.drawerlayout);
        navigationView=findViewById(R.id.navigview);
        toolbar=findViewById(R.id.toolbar);
    }

    void setFragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.add(R.id.student_frame,fragment);
        ft.commit();

    }

}