package com.example.riyaza.movieapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie> {



    // Tutorial followed Android Basic Multi screen course

    public MovieAdapter(@NonNull Context context, @NonNull List<Movie> objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Movie currentMovie= getItem(position);
        View gridView=convertView;
        if (gridView == null) {
            gridView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        ImageView imageView= (ImageView) gridView.findViewById(R.id.image);
        Picasso.with(getContext()).load(currentMovie.getPosterUrl()).placeholder(R.drawable.plcimage).into(imageView);
//       TextView textView=(TextView)gridView.findViewById(R.id.title);
//        textView.setText(currentMovie.getTitle());
        return gridView;
    }




}
