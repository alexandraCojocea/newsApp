package com.example.android.newsapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PostAdapter extends ArrayAdapter<Post> {

    public PostAdapter(Context context, List<Post> Posts) {
        super(context, 0, Posts);
    }

    static class ViewHolder {
        private TextView nameView;
        private TextView sectionView;
        private TextView authorView;
        private TextView dateView;
        private TextView timeView;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.post_list_item, parent, false);
            holder = new ViewHolder();
            holder.nameView = (TextView) convertView.findViewById(R.id.name);
            holder.sectionView = (TextView) convertView.findViewById(R.id.section);
            holder.authorView = (TextView) convertView.findViewById(R.id.author);
            holder.dateView = (TextView) convertView.findViewById(R.id.date);
            holder.timeView = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Post currentPost = getItem(position);

        holder.nameView.setText(currentPost.getName());
        holder.sectionView.setText(currentPost.getSection());
        holder.authorView.setText(currentPost.getAuthor());
        String timeFinal = formatDate(currentPost.getDate());
        holder.dateView.setText(timeFinal);
        String timeFinal2 = formatTime(currentPost.getDate());
        holder.timeView.setText(timeFinal2);

        return convertView;
    }

    private String formatDate(String date) {
        String jsonDatePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat jsonFormatter = new SimpleDateFormat(jsonDatePattern, Locale.US);
        try {
            Date parsedJsonDate = jsonFormatter.parse(date);
            String finalDatePattern = "MMM d, yyy";
            SimpleDateFormat finalDateFormatter = new SimpleDateFormat(finalDatePattern, Locale.US);
            return finalDateFormatter.format(parsedJsonDate);
        } catch (ParseException e) {
            Log.e("QueryUtils", "Error parsing JSON date: ", e);
            return "";
        }
    }

    private String formatTime(String date) {
        String jsonDatePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat jsonFormatter = new SimpleDateFormat(jsonDatePattern, Locale.US);
        try {
            Date parsedJsonDate = jsonFormatter.parse(date);
            String finalDatePattern = "hh:mm a";
            SimpleDateFormat finalDateFormatter = new SimpleDateFormat(finalDatePattern, Locale.US);
            return finalDateFormatter.format(parsedJsonDate);
        } catch (ParseException e) {
            Log.e("QueryUtils", "Error parsing JSON date: ", e);
            return "";
        }
    }
}
