package com.azizadx.newsly.data.model;

import java.util.ArrayList;

public class MainNews {
    private  String status;
    private  String totalResults;
    private ArrayList<NewsModel> article;
    private ArrayList<NewsFeedModel> articles;
    public MainNews(String status, String totalResults,ArrayList<NewsModel> article ,ArrayList<NewsFeedModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.article = article;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<NewsModel> getArticle() {
        return article;
    }

    public void setArticle(ArrayList<NewsModel> article) {
        this.article = article;
    }

    public ArrayList<NewsFeedModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsFeedModel> articles) {
        this.articles = articles;
    }
}
