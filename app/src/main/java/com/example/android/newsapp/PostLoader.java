package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class PostLoader extends AsyncTaskLoader<List<Post>> {

    private String mUrl;

    public PostLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Post> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<Post> Posts = QueryUtils.fetchPostData(mUrl);
        return Posts;
    }
}
