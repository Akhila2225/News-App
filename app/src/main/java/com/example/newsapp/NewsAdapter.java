package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context) {
        super(context, -1, new ArrayList<News>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView
                    = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.news_title);
        TextView author = (TextView) convertView.findViewById(R.id.news_author);
        TextView date = (TextView) convertView.findViewById(R.id.news_date);
        TextView section = (TextView) convertView.findViewById(R.id.news_category);

        News currentNews = getItem(position);
        title.setText(currentNews.getTitle());
        author.setText(currentNews.getAuthor());
        date.setText(currentNews.getDate());
        section.setText(currentNews.getCategory());

        return convertView;
    }
}
