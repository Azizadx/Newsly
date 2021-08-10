package com.azizadx.newsly.ui.main.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.azizadx.newsly.R;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        ImageSlider imageSlider=findViewById(R.id.slider);
        List<SlideModel> slideModels=new ArrayList<>();slideModels.add(new SlideModel(R.drawable.onboarding1));
        slideModels.add(new SlideModel(R.drawable.onboarding2));
        slideModels.add(new SlideModel(R.drawable.onboarding1));
        slideModels.add(new SlideModel(R.drawable.onboarding2));
        slideModels.add(new SlideModel(R.drawable.onboarding1));
        slideModels.add(new SlideModel(R.drawable.onboarding2));
        imageSlider.setImageList(slideModels,true);



    }

}