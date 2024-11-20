package com.example.quickreport;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLogin extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText useremail,userpassword;
    private Button userloginbtn;
    private TextView signupRedirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_login);
        init();
        auth= FirebaseAuth.getInstance();

        userloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = useremail.getText().toString().trim();
                String pass = userpassword.getText().toString().trim();

                // Check if the email is not empty and valid
                if(!email.isEmpty()&& Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                    // Check if the password is not empty
                    if (!pass.isEmpty()) {

                        // Authenticate using Firebase Auth
                        auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(AdminLogin.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AdminLogin.this, MainActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AdminLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        userpassword.setError("password cannot be empty");
                    }
                }else if (email.isEmpty()){
                    useremail.setError("Email cannot be empty");
                }else{
                    useremail.setError("Please enter valid email");
                }
            }

        });

        signupRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminLogin.this,AdminSignup.class));
            }
        });

    }

    void init(){
        useremail=findViewById(R.id.adminloginemail);
        userpassword=findViewById(R.id.adminloginpassword);
        userloginbtn=findViewById(R.id.adminloginbtn);
        signupRedirect=findViewById(R.id.adminsignupRedirect);
    }
}