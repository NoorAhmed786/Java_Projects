package com.tourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.ViewHolder> {

    Context context;
    ArrayList<Tour> tour_data;

    public TourAdapter(Context context, ArrayList<Tour> tour_data) {
        this.context = context;
        this.tour_data = tour_data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tourlayout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(tour_data.get(position).img);
        holder.txtplace.setText(tour_data.get(position).txt_place);

    }

    @Override
    public int getItemCount() {
        return tour_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtplace;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtplace = itemView.findViewById(R.id.txtplace);
            img = itemView.findViewById(R.id.img);
        }
    }
}
