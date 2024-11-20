package com.example.drawerlayout;

import android.os.Bundle;
import android.view.Gravity;
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
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle studentActionBar = new ActionBarDrawerToggle(this,
                drawerLayout,R.string.openStudent,R.string.closeStudent);
        drawerLayout.addDrawerListener(studentActionBar);
        studentActionBar.syncState();

        setfragment(new CreateFragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               int i = item.getItemId();
               if(i==R.id.create){
                   setfragment(CreateFragment.getInstance("Noor",25));
                   Toast.makeText(MainActivity.this, "Create", Toast.LENGTH_SHORT).show();
               } else if (i==R.id.Read) {
                   setfragment(new ReadFragment());
                   Toast.makeText(MainActivity.this, "Read", Toast.LENGTH_SHORT).show();

               } else if (i==R.id.delete) {
                   setfragment(new DeleteFragment());
                   Toast.makeText(MainActivity.this, "delete", Toast.LENGTH_SHORT).show();

               }else {
                   setfragment(new UpdateFragment());
                   Toast.makeText(MainActivity.this, "Update", Toast.LENGTH_SHORT).show();
               }
               drawerLayout.closeDrawer(GravityCompat.START);

               return true;
            }
        });

    }

    void setfragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.studentFrame,fragment);
        ft.commit();

    }
    void init(){
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigView);
        toolbar=findViewById(R.id.toolbar);
    }
}