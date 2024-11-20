package com.example.firebaseapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
   EditText firstname,lastname,email,address;
   Button btnsubmit;
   FirebaseDatabase firebaseDatabase;
   DatabaseReference databaseReference;
   Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname,lname,mail,Address;
                fname=firstname.getText().toString();
                lname=lastname.getText().toString();
                mail=email.getText().toString();
                Address=address.getText().toString();

                if(TextUtils.isEmpty(fname)&&TextUtils.isEmpty(lname)&&TextUtils.isEmpty(mail)&&TextUtils.isEmpty(Address)){
                    Toast.makeText(MainActivity.this, "Please all feild", Toast.LENGTH_SHORT).show();

                }else {
                    add_student(fname,lname,mail,Address);

                }
            }
        });

    }
    public  void init(){
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        email=findViewById(R.id.email);
        address=findViewById(R.id.address);
        btnsubmit=findViewById(R.id.btnsubmit);

        student=new Student();

        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Student");
    }

    public  void add_student(String First_Name,String Last_Name,String Email,String Address){
        student.First_name=First_Name;
        student.Last_name=Last_Name;
        student.Email=Email;
        student.Address=Address;
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(student);
                Toast.makeText(MainActivity.this, "sucessfull add data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Fail to store data", Toast.LENGTH_SHORT).show();

            }
        });
    }
}