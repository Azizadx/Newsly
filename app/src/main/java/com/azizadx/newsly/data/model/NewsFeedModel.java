package com.azizadx.newsly.data.model;

public class NewsFeedModel {
    private String title,urlToImage,url;



    public NewsFeedModel( String title, String urlToImage) {
        this.title = title;
        this.urlToImage = urlToImage;
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
