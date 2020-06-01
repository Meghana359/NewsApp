package com.example.admin.newsapp;

public class News {
    private String mTitle;
    private String mSection;
    private String mAuthor;
    private String mDate;
    private String mUrl;

    public News(String title, String section, String author, String date, String url) {
        this.mTitle = title;
        this.mSection = section;
        this.mAuthor = author;
        this.mDate = date;
        this.mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSection() {
        return mSection;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDate() {
        return mDate;
    }
}
