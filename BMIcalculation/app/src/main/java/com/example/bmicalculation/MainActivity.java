package com.example.bmicalculation;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText editTextWeight =findViewById(R.id.weight);
        EditText editTextHeight =findViewById(R.id.height);
        Button btn =findViewById(R.id.btn_submit);
        TextView text =findViewById(R.id.result);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float height= Float.parseFloat(String.valueOf(editTextHeight.getText()))/100;
                float weight= Float.parseFloat(String.valueOf(editTextWeight.getText()));
                float bmi= weight/(height*height);
                float res= Math.round(bmi);

                text.setText(String.valueOf(res));
            }
        });

    }



}