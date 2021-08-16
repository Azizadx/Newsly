package com.azizadx.newsly.ui.main.view.newsfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azizadx.newsly.R;
import com.azizadx.newsly.data.api.ApiUtitl;
import com.azizadx.newsly.data.model.MainNews;
import com.azizadx.newsly.data.model.NewsFeedModel;
import com.azizadx.newsly.data.model.NewsModel;
import com.azizadx.newsly.ui.main.adopter.Adaptor;
import com.azizadx.newsly.ui.main.adopter.NewsFeedAdaptor;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeneralFrg extends Fragment {

    String country = "us";
    String api = "d8874f9df1164bc3af8101018531cedf";
    ArrayList<NewsFeedModel> modelArrayList;
    NewsFeedAdaptor adaptor ;
    private RecyclerView recyclerViewofgeneral;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_general,null);
        recyclerViewofgeneral = v.findViewById(R.id.rcviewofgeneral);
        modelArrayList = new ArrayList<>();
        recyclerViewofgeneral.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptor = new NewsFeedAdaptor(getContext(),modelArrayList);
        recyclerViewofgeneral.setAdapter(adaptor);

        findNews();

        return  v;
    }

    private void findNews() {
        ApiUtitl.getApiInterface().getNews(country,100,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
//                System.out.println(response);
                if (response.isSuccessful()) {
                    modelArrayList.addAll(response.body().getArticles());
                    adaptor.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {


            }
        });
    }
}
