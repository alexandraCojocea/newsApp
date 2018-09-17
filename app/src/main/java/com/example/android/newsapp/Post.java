package com.example.android.newsapp;

public class Post {

    private String mName;

    private String mDate;

    private String mSection;

    private String mAuthor;

    private String mUrl;

    public Post(String name, String section, String date, String author, String url) {
        mName = name;
        mSection = section;
        mDate = date;
        mAuthor = author;
        mUrl = url;
    }

    public String getName() {
        return mName;
    }

    public String getSection() {
        return mSection;
    }

    public String getDate() {
        return mDate;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getUrl() {
        return mUrl;
    }
}
