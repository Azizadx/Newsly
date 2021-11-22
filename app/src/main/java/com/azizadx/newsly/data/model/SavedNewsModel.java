package com.azizadx.newsly.data.model;

public class SavedNewsModel{

    private String title;
    private String urlToImage;
    private String url;
    private String cat;





    public SavedNewsModel( String title, String urlToImage, String url,String cat) {
        this.title = title;
        this.urlToImage = urlToImage;
        this.url = url;
        this.cat = cat;


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

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }




}


