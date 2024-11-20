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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminSignup extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText signupEmail,signupPassword;
    private Button signupButton;
    private TextView loginRedirectText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_signup);
        init();

        auth= FirebaseAuth.getInstance();
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email =signupEmail.getText().toString().trim();
                String pass =signupPassword.getText().toString().trim();

                if(email.isEmpty()){
                    signupEmail.setError("email cannot be empty");
                }
                if(pass.isEmpty()){
                    signupPassword.setError("Password cannot be empty");
                }
                else {
                    auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(AdminSignup.this, "Signup Sucessfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AdminSignup.this,AdminLogin.class));
                            }
                            else {
                                Toast.makeText(AdminSignup.this, "Signup Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminSignup.this,AdminLogin.class));
            }
        });
    }

    void init(){
        signupEmail=findViewById(R.id.adminsignupemail);
        signupPassword=findViewById(R.id.adminsignuppassword);
        signupButton=findViewById(R.id.adminsignupbtn);
        loginRedirectText=findViewById(R.id.adminloginRedirect);
    }
}