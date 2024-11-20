package com.example.quickreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ComplainAdapter extends RecyclerView.Adapter<ComplainAdapter.ViewHolder> {
    private Context context;
    private List<DataClass> dataList;

    public ComplainAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ComplainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userdata_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplainAdapter.ViewHolder holder, int position) {
        DataClass data = dataList.get(position);

        // Log to debug Glide loading
        Log.d("GlideBinding", "Loading image: " + data.getDataImage());

        // Check if image URL is valid
        if (data.getDataImage() != null && !data.getDataImage().isEmpty()) {
            Glide.with(context)
                    .load(data.getDataImage())
                    .placeholder(R.drawable.baseline_add_photo_alternate_24)
                    .error(R.drawable.road)
                    .into(holder.recImage);
        } else {
            holder.recImage.setImageResource(R.drawable.road);  // Set default image
        }

        // Bind other views
        holder.recComplain.setText(data.getDataTitle());
        holder.recArea.setText(data.getDataArea());
        holder.recDesc.setText(data.getDataDesc());


        // Set onClickListener for each card
        holder.Card.setOnClickListener(view -> {
            Intent intent = new Intent(context, ComplainActivity.class);
            intent.putExtra("dataImage", dataList.get(holder.getAdapterPosition()).getDataImage());
            intent.putExtra("dataTitle", dataList.get(holder.getAdapterPosition()).getDataTitle());
            intent.putExtra("dataDesc", dataList.get(holder.getAdapterPosition()).getDataDesc());
            intent.putExtra("dataArea", dataList.get(holder.getAdapterPosition()).getDataArea());
            intent.putExtra("Key", dataList.get(holder.getAdapterPosition()).getKey());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    @SuppressLint("NotifyDataSetChanged")
    public void searchDataList(ArrayList<DataClass> searchList) {
        this.dataList = searchList;
        notifyDataSetChanged();
    }
public class ViewHolder extends RecyclerView.ViewHolder{
     ImageView recImage;
     TextView recComplain,recDesc,recArea;
     CardView Card;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        recImage=itemView.findViewById(R.id.recTmage);
        recComplain=itemView.findViewById(R.id.recComplain);
        recDesc=itemView.findViewById(R.id.recDesc);
        recArea=itemView.findViewById(R.id.recarea);
        Card=itemView.findViewById(R.id.card);
    }
}
}

