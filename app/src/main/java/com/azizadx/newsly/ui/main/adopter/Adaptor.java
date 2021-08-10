package com.azizadx.newsly.ui.main.adopter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.azizadx.newsly.R;
import com.azizadx.newsly.data.model.NewsModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adaptor extends RecyclerView.Adapter<Adaptor.ViewHolder> {
    Context context ;
    ArrayList<NewsModel> modelClassArrayList;

    public Adaptor(Context context, ArrayList<NewsModel> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptor.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("content is selected");
//                Intent intent = new Intent(context,webView.class);
//                intent.putExtra("url",modelClassArrayList.get(position).getUrl());
            }
        });

        holder.mtime.setText("Published At:-"+modelClassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mheading.setText(modelClassArrayList.get(position).getTitle());
        holder.mcontent.setText(modelClassArrayList.get(position).getDescription());
//        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading,mcontent,mauthor,mtime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.mainheading);
//            mcontent = itemView.findViewById(R.id.content);
//            mauthor = itemView.findViewById(R.id.author);
//            mtime = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cardview);
//            imageView = itemView.findViewById(R.id.imageview);
        }
    }
}
