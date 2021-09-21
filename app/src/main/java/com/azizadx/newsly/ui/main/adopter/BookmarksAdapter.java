package com.azizadx.newsly.ui.main.adopter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.azizadx.newsly.R;
import com.azizadx.newsly.data.model.BookmarksDB;
import com.azizadx.newsly.data.model.NewsFeedModel;
import com.azizadx.newsly.data.model.SavedNewsModel;
import com.azizadx.newsly.ui.main.view.ArticlePage;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookmarksAdapter extends RecyclerView.Adapter<BookmarksAdapter.ViewHolder> {


    ArrayList<SavedNewsModel> svdnewmodel ;
    Context context ;

    public BookmarksAdapter(Context context,ArrayList<SavedNewsModel> svdnewmodel) {
        this.context = context;
        this.svdnewmodel = svdnewmodel;
    }

    @NonNull
    @Override
    public BookmarksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_bookmarked_item,null,false);
        return new BookmarksAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarksAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        SavedNewsModel a = svdnewmodel.get(position);
        String imageUrl = a.getUrlToImage();
        String c = a.getCat();

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //fix intent - url is passing / why webview isn't getting it?
                Intent intent = new Intent(context, ArticlePage.class);
                intent.putExtra("url",a.getUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                context.startActivity(intent);
            }
        });

holder.icat.setText(c);

        holder.mheading.setText(svdnewmodel.get(position).getTitle());
        Glide.with(context)
                .load(imageUrl).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return svdnewmodel.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading,icat;
        CardView cardView;
        ImageView imageView;
        ImageButton bookmarkbtn;
String iU, rU;
        Boolean clicked = true;
        int fSt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.mainheading);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.imageview);
            bookmarkbtn = itemView.findViewById(R.id.bookmarkbtn);

            icat = itemView.findViewById(R.id.cat);

            //add button onclick handler here

            bookmarkbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos =getAdapterPosition();
                    SavedNewsModel svnm = svdnewmodel.get(pos);
                    iU = svnm.getUrlToImage();
                    rU= svnm.getUrl();
                    if(clicked) {
                        clicked = true;
//                        bookmarkbtn.setImageResource(R.drawable.ic_bookmark_turned_in_not);
                        //add delete query call here
                        BookmarksDB db = new BookmarksDB(context.getApplicationContext());
                        Cursor c = db.getAll();
                        int position = getAdapterPosition();
                        SavedNewsModel a = svdnewmodel.get(position);
                        String nm = a.getTitle();
                        Toast.makeText(context.getApplicationContext(), "Removed from bookmarks!", Toast.LENGTH_SHORT).show();
                          db.Delete(nm);
                        svdnewmodel.remove(svdnewmodel.get(position));
                        notifyDataSetChanged();
                        db.close();
                    } else
                    {
                        clicked = false;
                        fSt = 0;
//                        bookmarkbtn.setImageResource(R.drawable.ic_bookmark_turned_in);
                         notifyDataSetChanged();
                    }

                }
            });
        }
    }
}
