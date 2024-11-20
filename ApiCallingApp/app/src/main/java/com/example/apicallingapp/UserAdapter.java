package com.example.apicallingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context context;
    ArrayList<Posts> userdata;

    public UserAdapter(Context context, ArrayList<Posts> userdata) {
        this.context = context;
        this.userdata = userdata;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userlayout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.nameTextView.setText(userdata.get(position).name);
        holder.usernameTextView.setText(userdata.get(position).username);
        holder.emailTextView.setText(userdata.get(position).email);
        holder.phoneTextView.setText(userdata.get(position).phone);
        holder.websiteTextView.setText(userdata.get(position).website);
        holder.streetTextView.setText(userdata.get(position).street);
        holder.suiteTextView.setText(userdata.get(position).suite);
        holder.cityTextView.setText(userdata.get(position).city);
        holder.zipcodeTextView.setText(userdata.get(position).zipcode);
        holder.companyNameTextView.setText(userdata.get(position).company_name);
        holder.catchpraseTextView.setText(userdata.get(position).catchPhrase);
        holder.businessStrategiesTextView.setText(userdata.get(position).bs);


    }

    @Override
    public int getItemCount() {
        return userdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView,usernameTextView,emailTextView,phoneTextView,
                websiteTextView,streetTextView,suiteTextView,cityTextView,zipcodeTextView,
                geoLatTextView,latitudeTextView, companyNameTextView,catchpraseTextView,businessStrategiesTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView=itemView.findViewById(R.id.tv_user_name);
            usernameTextView=itemView.findViewById(R.id.tv_user_username);
            emailTextView=itemView.findViewById(R.id.tv_user_email);
            phoneTextView=itemView.findViewById(R.id.tv_user_phone);
            websiteTextView=itemView.findViewById(R.id.tv_user_website);
            streetTextView=itemView.findViewById(R.id.tv_address_street);
            suiteTextView=itemView.findViewById(R.id.tv_address_suite);
            cityTextView=itemView.findViewById(R.id.tv_address_city);
            zipcodeTextView=itemView.findViewById(R.id.tv_address_zipcode);
            geoLatTextView=itemView.findViewById(R.id.tv_geo_lat);
            latitudeTextView=itemView.findViewById(R.id.tv_geo_lng);
            companyNameTextView=itemView.findViewById(R.id.tv_company_name);
            catchpraseTextView=itemView.findViewById(R.id.tv_company_catchPhrase);
            businessStrategiesTextView=itemView.findViewById(R.id.tv_company_bs);

        }
    }
}
