package com.azizadx.newsly.data.model;

public class NewsFeedModel {
    private String title,urlToImage;


    public NewsFeedModel( String title, String urlToImage) {
        this.title = title;
        this.urlToImage = urlToImage;

    }



    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }


}
