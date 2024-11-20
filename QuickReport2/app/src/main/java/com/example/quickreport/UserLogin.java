package com.example.quickreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class UserLogin extends AppCompatActivity {
    EditText LoginName,LoginPassword;
    Button loginButton;
    TextView signupRedirectText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_login);
        init();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateUserName() | !validateUserPassword()){

                }else {
                    checkUser();
                }
            }
        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLogin.this,UserSignup.class);
                startActivity(intent);
            }
        });



    }

    public boolean validateUserName(){
        String val = LoginName.getText().toString();
        if(val.isEmpty()){
            LoginName.setError("Username cannot be empty");
            return false;
        }
        else {
            LoginName.setError(null);
            return  true;
        }
    }
    public boolean validateUserPassword(){
        String val = LoginPassword.getText().toString();
        if(val.isEmpty()){
            LoginPassword.setError("Userpassword cannot be empty");
            return false;
        }
        else {
            LoginPassword .setError(null);
            return  true;
        }
    }

    public  void checkUser(){
        String userName = LoginName.getText().toString().trim();
        String userPass = LoginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkuserDatabse = reference.orderByChild("name").equalTo(userName);

         checkuserDatabse.addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {
                 if(snapshot.exists()){
                     LoginName.setError(null);
                     String passFromDb = snapshot.child(userName).child("password").getValue(String.class);

                     if(Objects.equals(passFromDb,userPass)){
                         LoginName.setError(null);
                         Intent intent = new Intent(UserLogin.this,MainActivity.class);
                         intent.putExtra("name",userName);
                         startActivity(intent);
                     }else{
                         LoginPassword.setError("Invalid Crediontials");
                         LoginPassword.requestFocus();

                     }
                 }else {
                     LoginName.setError("Invalid Crediontials");
                     LoginName.requestFocus();

                 }
             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {
                 Toast.makeText(UserLogin.this, "error", Toast.LENGTH_SHORT).show();

             }
         });

    }

    void init(){
        LoginName=findViewById(R.id.userloginName);
        LoginPassword=findViewById(R.id.userloginpassword);
        loginButton=findViewById(R.id.userloginbtn);
        signupRedirectText=findViewById(R.id.usersignupredirect);
    }
}