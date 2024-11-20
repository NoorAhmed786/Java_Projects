package com.example.drawerlayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CreateFragment extends Fragment {
//parameter as a key
    public static String Param1="Param1";
    public static String Param2="Param2";

    public CreateFragment() {
        // Required empty public constructor
    }
   public  static CreateFragment getInstance(String param1,int param2){
        CreateFragment createFragment= new CreateFragment();
        Bundle bundle= new Bundle();
        bundle.putString(Param1,param1);
        bundle.putInt(Param2,param2);
        createFragment.setArguments(bundle);

        return createFragment;
   }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView name,age;
        String Name;
        int Age;
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_create, container, false);
        name=v.findViewById(R.id.name);
        age=v.findViewById(R.id.age);
        if(getArguments() != null){
            Name= getArguments().getString(Param1);
            Age=getArguments().getInt(Param2);

            name.setText(String.valueOf(Age));
            age.setText(Name);
        }


        return  v;
    }
}