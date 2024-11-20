package com.example.whatsapp_lite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WhatsAdapter extends RecyclerView.Adapter<WhatsAdapter.ViewHolder> {
    Context context;
    ArrayList<WhatsClass> user_data;

    public WhatsAdapter(Context context, ArrayList<WhatsClass> user_data) {
        this.context = context;
        this.user_data = user_data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.whtaslayout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(user_data.get(position).img);
        holder.txtplace.setText(user_data.get(position).txtplace);
        holder.txtplace2.setText(user_data.get(position).txtplace2);

    }

    @Override
    public int getItemCount() {
        return user_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtplace,txtplace2;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtplace=itemView.findViewById(R.id.txtplace);
            txtplace2=itemView.findViewById(R.id.txtplace2);
            img=itemView.findViewById(R.id.img);
        }


    }
}
