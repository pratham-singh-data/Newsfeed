package com.example.newsfeed;

import java.util.ArrayList;

public class ResponseModel {
    private String status;
    private String totalResults;
    private ArrayList<ArticleModel> articles;

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

    public ArrayList<ArticleModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ArticleModel> articles) {
        this.articles = articles;
    }

    public ResponseModel(String status, String totalResults, ArrayList<ArticleModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }
}
