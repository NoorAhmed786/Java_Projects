package com.example.quickreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ComplainActivity extends AppCompatActivity {
    TextView complainText, complainDesc, complainArea;
    ImageView complainImage;
    FloatingActionButton deleteBtn,editBtn;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_complain);
        init();

        // Getting the passed bundle data
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            complainDesc.setText(bundle.getString("dataDesc"));
            complainText.setText(bundle.getString("dataTitle"));
            complainArea.setText(bundle.getString("dataArea"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("dataImage");

            // Load the image using Glide
            Glide.with(this).load(bundle.getString("dataImage")).into(complainImage);
        }

        // Set the delete button click listener
        deleteBtn.setOnClickListener(view -> {
            final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Android Tutorials");
            FirebaseStorage storage = FirebaseStorage.getInstance();

            if (imageUrl != null && !imageUrl.isEmpty()) {
                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                storageReference.delete().addOnSuccessListener(unused -> {
                    if (key != null && !key.isEmpty()) {
                        reference.child(key).removeValue();
                        Toast.makeText(ComplainActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(ComplainActivity.this, "Invalid key", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(e -> {
                    Toast.makeText(ComplainActivity.this, "Error deleting image", Toast.LENGTH_SHORT).show();
                });
            } else {
                Toast.makeText(ComplainActivity.this, "Image URL is empty or null", Toast.LENGTH_SHORT).show();
            }
        });
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ComplainActivity.this,UpdateActivity.class)
//                        .putExtra("dataTitle",complainText.getText().toString())
//                        .putExtra("dataDesc",complainDesc.getText().toString())
//                        .putExtra("dataArea",complainArea.getText().toString())
//                        .putExtra("Key",key)
//                        .putExtra("dataImage",imageUrl);
//                startActivity(intent);

                Intent intent = new Intent(ComplainActivity.this, UpdateActivity.class)
                        .putExtra("dataTitle", complainText.getText().toString())
                        .putExtra("dataDesc", complainDesc.getText().toString())
                        .putExtra("dataArea", complainArea.getText().toString())
                        .putExtra("Key", key)
                        .putExtra("dataImage", imageUrl); // Ensure this key matches in both activities
             startActivity(intent);

            }
        });


    }

    // Initialize all UI components
    void init() {
        complainText = findViewById(R.id.complaintitle);
        complainDesc = findViewById(R.id.complainDesc);
        complainArea = findViewById(R.id.complainArea);
        complainImage = findViewById(R.id.complainImage);
        deleteBtn = findViewById(R.id.deletebtn);
        editBtn = findViewById(R.id.editbtn);
    }
}
