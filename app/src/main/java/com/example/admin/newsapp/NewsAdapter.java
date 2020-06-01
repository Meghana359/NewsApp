package com.example.admin.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(@NonNull Context context, @NonNull List<News> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String author;
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }
        News currentNews = getItem(position);
        TextView titleView = listItemView.findViewById(R.id.title);
        titleView.setText(currentNews.getTitle());
        TextView sectionNameView = listItemView.findViewById(R.id.sectionName);
        sectionNameView.setText(currentNews.getSection());

        if (!currentNews.getAuthor().isEmpty()) {
            author = "by " + currentNews.getAuthor();
        } else {
            author = "No Author Name Found";
        }

        TextView authorView = listItemView.findViewById(R.id.author);
        authorView.setText(author);
        TextView dateView = listItemView.findViewById(R.id.date);
        String date = currentNews.getDate();
        String formattedDate = "Pub.: " + formatDate(date);
        dateView.setText(formattedDate);
        return listItemView;
    }

    private String formatDate(String dateObject) {
        Date formattedDate = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            formattedDate = dateFormat.parse(dateObject);
            dateFormat = new SimpleDateFormat("dd-MM-yyyy, HH:mm");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(formattedDate);
    }
}
