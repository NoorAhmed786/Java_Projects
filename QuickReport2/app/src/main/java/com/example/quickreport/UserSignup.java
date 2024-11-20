package com.example.quickreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserSignup extends AppCompatActivity {
    EditText signupEmail,signupPassword ,userName;
     Button signupButton;
     TextView loginRedirectText;
     FirebaseDatabase database;
     DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_signup);
        init();
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database= FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = userName.getText().toString().trim();
                String email = signupEmail.getText().toString().trim();
                String password = signupPassword.getText().toString().trim();

                UserFormData userFormData= new UserFormData(name,email,password);
                reference.child(name).setValue(userFormData);

                Toast.makeText(UserSignup.this, "You have signup sucessfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserSignup.this,UserLogin.class);
                startActivity(intent);


            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserSignup.this,UserLogin.class);
                startActivity(intent);

            }
        });

    }

    void  init(){
        signupEmail=findViewById(R.id.userSignupemail);
        signupPassword=findViewById(R.id.userSignuppassword);
        userName=findViewById(R.id.username);
        signupButton=findViewById(R.id.usersignupbtn);
        loginRedirectText=findViewById(R.id.userloginredirect);
    }
}