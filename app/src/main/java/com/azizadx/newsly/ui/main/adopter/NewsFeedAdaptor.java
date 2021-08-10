package com.azizadx.newsly.ui.main.adopter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.azizadx.newsly.R;
import com.azizadx.newsly.data.model.NewsFeedModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import java.io.File;
import java.util.ArrayList;

public class NewsFeedAdaptor extends RecyclerView.Adapter<NewsFeedAdaptor.ViewHolder> {
    Context context ;
    ArrayList<NewsFeedModel> modelClassArrayList;

    public NewsFeedAdaptor(Context context, ArrayList<NewsFeedModel> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public NewsFeedAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("content is selected");
//                Intent intent = new Intent(context,webView.class);
//                intent.putExtra("url",modelClassArrayList.get(position).getUrl());
            }
        });
//        GlideUrl url = new GlideUrl(, new LazyHeaders.Builder()
//                .addHeader("User-Agent", WebSettings.getDefaultUserAgent(context))
//                .build());


        holder.mheading.setText(modelClassArrayList.get(position).getTitle());
        Glide.with(context)
                .load(modelClassArrayList.get(position).getUrlToImage())
                .into(holder.imageView);



    }


    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.mainheading);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.imageview);
        }
    }
}