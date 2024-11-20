package com.example.fb_lite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.ViewHolder> {
    Context context;
    ArrayList<Tour> tour_data;

    public TourAdapter(Context context, ArrayList<Tour> tour_data) {
        this.context = context;
        this.tour_data = tour_data;
    }

    @NonNull
    @Override
    public TourAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.tourlayout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TourAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(tour_data.get(position).img);
        holder.txtpalce.setText(tour_data.get(position).txt_place);

    }

    @Override
    public int getItemCount() {
        return tour_data.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtpalce;
        ImageView img;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtpalce=itemView.findViewById(R.id.txtplace);
            img=itemView.findViewById(R.id.img);
        }
    }
}
