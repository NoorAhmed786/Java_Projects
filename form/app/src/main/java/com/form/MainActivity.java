package com.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
   EditText edtname,edtemail,edtsems;
   Button btnsubmit;
   String Name,Email,Semester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name = edtname.getText().toString();
                Email = edtemail.getText().toString();
                Semester = edtsems.getText().toString();

                Intent next;
                next = new Intent(MainActivity.this,DetailActivity2.class);
                next.putExtra("name",Name);
                next.putExtra("email",Email);
                next.putExtra("semester",Semester);
                startActivity(next);
            }
        });

    }



    void init(){
        btnsubmit=findViewById(R.id.btnsubmit);
        edtname=findViewById(R.id.edtname);
        edtemail=findViewById(R.id.edtemail);
        edtsems=findViewById(R.id.edtsems);
    }
}
