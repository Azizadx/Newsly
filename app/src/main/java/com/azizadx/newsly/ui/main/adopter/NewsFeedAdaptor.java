package com.azizadx.newsly.ui.main.adopter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.azizadx.newsly.R;
import com.azizadx.newsly.data.model.BookmarksDB;
import com.azizadx.newsly.data.model.NewsFeedModel;
import com.azizadx.newsly.data.model.NewsModel;
import com.azizadx.newsly.data.respository.PageAdapter;
import com.azizadx.newsly.ui.main.view.ArticlePage;
import com.azizadx.newsly.ui.main.view.MainActivity;
import com.azizadx.newsly.ui.main.view.newsfragment.BusinessFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.EntertainmentFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.GeneralFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.HealthFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.ScienceFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.SportFrg;
import com.azizadx.newsly.ui.main.view.newsfragment.TechnologyFrg;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
//

public class NewsFeedAdaptor extends RecyclerView.Adapter<NewsFeedAdaptor.ViewHolder> {
    Context context ;
    Context context2;
    ArrayList<NewsFeedModel> modelClassArrayList;
    ArrayList<NewsModel> singleModel;
    Adaptor adaptor2;
    NewsFeedAdaptor adaptor ;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final NewsFeedModel nm = modelClassArrayList.get(position);
        String imageUrl = nm.getUrlToImage();
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("content is selected from MainActivity"+modelClassArrayList.get(position).getUrl());
                Intent intent = new Intent(context, ArticlePage.class);
                intent.putExtra("url",nm.getUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
              context.startActivity(intent);
            }
        });

        holder.url.setText(nm.getUrl());
        holder.iurl.setText(nm.getUrlToImage());

        holder.mheading.setText(modelClassArrayList.get(position).getTitle());
        Glide.with(context)
                .load(imageUrl).into(holder.imageView);

    }
    
    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView mheading,url,iurl;
        CardView cardView;
        ImageView imageView;
        ImageButton bookmarkbtn;
        String article_name, article_image,cat;
        Boolean clicked = true;



        public String  categoryName () {
          cat = ((MainActivity)context).setCategory().toString();
            return cat;
               }


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.mainheading);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.imageview);
            bookmarkbtn = itemView.findViewById(R.id.bookmarkbtn);
            url = itemView.findViewById(R.id.url);
            iurl = itemView.findViewById(R.id.imgurl);


            bookmarkbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    categoryName();

                    //parameters to store in db -article name, url and img url
int position =getAdapterPosition();
            NewsFeedModel nmm = modelClassArrayList.get(position);
            article_name = nmm.getTitle();
            article_image = nmm.getUrlToImage();
             String article_url=  url.getText().toString();
             String article_cat =  cat;

                    if(clicked) {
                        clicked = false;
                        BookmarksDB db = new BookmarksDB(context.getApplicationContext());
                        db.insertToDb(article_name,article_url,article_image,article_cat);
                        bookmarkbtn.setImageResource(R.drawable.ic_bookmark_turned_in);
                        notifyDataSetChanged();
                        db.close();

                        //crashes if you bookmark from General tab first
                        //doesn't crash when you save from a different tab first then come to general. Why?
                        // check changes made in GeneralFrg and revert to commented out version if it's not helpful

                    } else
                    {
                        clicked = true;
                        bookmarkbtn.setImageResource(R.drawable.ic_bookmark_turned_in_not);

                        //call delete
                        BookmarksDB db = new BookmarksDB(context.getApplicationContext());
                        db.Delete(article_name);
                        notifyDataSetChanged();
                    }
                }
            });

        }
    }
}
