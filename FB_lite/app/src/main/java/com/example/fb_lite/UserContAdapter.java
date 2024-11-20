package com.example.fb_lite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserContAdapter extends RecyclerView.Adapter<UserContAdapter.ViewHolder> {
    Context context;
    ArrayList<UserContent> UserData;

    public UserContAdapter(Context context, ArrayList<UserContent> userData) {
        this.context = context;
        UserData = userData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userName.setText(UserData.get(position).userName);
        holder.contentText.setText(UserData.get(position).contntText);
        holder.userImage.setImageResource(UserData.get(position).userImage);
        holder.contentPic.setImageResource(UserData.get(position).contentImage);

    }

    @Override
    public int getItemCount() {
        return UserData.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView userName,contentText;
        ImageView userImage,contentPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName=itemView.findViewById(R.id.userName);
            contentText=itemView.findViewById(R.id.contentText);
            userImage=itemView.findViewById(R.id.userImage);
            contentPic=itemView.findViewById(R.id.contentPic);
        }
    }
}
