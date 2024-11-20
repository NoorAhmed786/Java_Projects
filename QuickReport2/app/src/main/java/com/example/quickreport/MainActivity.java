package com.example.quickreport;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton fab;
    RecyclerView recyclerView;
     List<DataClass> datalist;
      ComplainAdapter adapter;
    DatabaseReference databaseReference;
    ValueEventListener valueEventListener;
    ImageButton callButton,logoutButton;
    BottomNavigationView bottomNavigationView;
    FirebaseAuth mAuth;
    TextView userText;
    SearchView searchView;
    private static final int REQUEST_CALL_PERMISSION = 1;
    private String phoneNumber = "tel:+1234567890";  // Replace with actual phone number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        init();

//   ;

        // Initialize FirebaseAuth
        mAuth = FirebaseAuth.getInstance();





        // Get user-related data separately
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String userName = bundle.getString("name");
            if (userName != null) {
                userText.setText(userName);
            }
        }

        // Check if the logged-in user is an admin (assuming an 'isAdmin' field in Firebase)
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(currentUser.getUid());
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists() && snapshot.hasChild("isAdmin")) {
                        boolean isAdmin = snapshot.child("isAdmin").getValue(Boolean.class);
                        if (isAdmin) {
//                            showAdminOptions(); // Show admin-specific UI elements
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle error
                }
            });
        }


        // Set an onClick listener on the logout button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sign out the user
                mAuth.signOut();


                // Redirect to login screen
                Intent intent = new Intent(MainActivity.this, UserLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); // Clears the backstack
                startActivity(intent);
                finish(); // Close the current activity
            }
        });
//        fab button for uploating data

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "FAB clicked!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, UploadActivity.class);
                startActivity(intent);
            }
        });
//        ==============  set layout in recyclerview ========

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
//        ========== show alert box ======

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progresslayout);
        AlertDialog dialog = builder.create();
        dialog.show();
//        === initialize Arrylist ============

        datalist = new ArrayList<>();
//        ===============  set adapter ===========

        adapter = new ComplainAdapter(MainActivity.this,datalist);
        recyclerView.setAdapter(adapter);
//============== database connection ===========
        databaseReference = FirebaseDatabase.getInstance().getReference("Android Tutorials");
        dialog.show();

        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                datalist.clear();
                for (DataSnapshot itemsnapshot : snapshot.getChildren()) {
                    DataClass dataClass = itemsnapshot.getValue(DataClass.class);
                    dataClass.setKey(itemsnapshot.getKey());
                    datalist.add(dataClass);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("FirebaseError", "Error fetching data", error.toException());
                dialog.dismiss();
            }
        });

        //        ========== search icon =====

//        Search VIEW focus
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });






//        ===========   phone call ================

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }

    private void makePhoneCall() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(phoneNumber));
            startActivity(intent);
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            }
        }

//        bottom navigate

//        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.nav_home:
//                    // Navigate to HomeActivity
//                    startActivity();
//                    return true;
//                case R.id.nav_profile:
//                    // Navigate to ProfileActivity
//                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
//                    return true;
//                default:
//                    return false;
//            }
//        });






    }
//    for search Arraylist to set adapter for searching

    public void searchList(String text) {
        ArrayList<DataClass> searchList = new ArrayList<>();
        for (DataClass dataClass : datalist) {
            if (dataClass.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                searchList.add(dataClass);
            }
        }
        adapter.searchDataList(searchList);
    }




    void init() {
        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler);
        callButton = findViewById(R.id.callButton);
        userText=findViewById(R.id.userTextName);
        logoutButton=findViewById(R.id.logoutButton);
        searchView=findViewById(R.id.serachview);
    }
}
