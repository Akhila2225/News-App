package com.example.newsapp;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.loader.content.AsyncTaskLoader;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<News> loadInBackground() {
        List<News> listOfNews = null;
        try {
            URL url = QueryUtils.createUrl();
            String jsonResponse = QueryUtils.makeHttpRequest(url);
            listOfNews = QueryUtils.parseJson(jsonResponse);
        } catch (IOException e) {
            Log.e("Queryutils", "Error Loader LoadInBackground: ", e);
        }
        return listOfNews;
    }
}
