package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class update extends AppCompatActivity {
    Button btndelete,btnupdate;
    EditText edtupdt;
    String position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);
        init();

        Intent intent = getIntent();
        String itemValue = intent.getStringExtra("item_value");
        position =intent.getStringExtra("item_value");
        edtupdt.setText(itemValue);



        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String Updatevalue = edtupdt.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("update_value",Updatevalue);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("update_value",true);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
    void  init(){
        btndelete=findViewById(R.id.btndelete);
        btnupdate=findViewById(R.id.btnupdate);
        edtupdt=findViewById(R.id.edtupdt);
    }

}