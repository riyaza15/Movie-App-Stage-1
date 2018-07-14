package com.example.riyaza.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView= (ImageView) findViewById(R.id.image);
        TextView textViewTitle= (TextView)findViewById(R.id.title);
        TextView textViewReleaseDate= (TextView) findViewById(R.id.releaseDate);
        TextView textViewOverView =(TextView) findViewById(R.id.overView);
        TextView textViewVoteAverage= (TextView) findViewById(R.id.voteAverage);

        Intent intent= getIntent();
        String imageUrl= intent.getStringExtra("PosterUrl");
        String title = intent.getStringExtra("Titel");
        String releaseDate=intent.getStringExtra("ReleaseDate");
        String overView= intent.getStringExtra("OverView");
        double voteAverage= intent.getDoubleExtra("VoteAverage",0);

        Picasso.with(getApplicationContext()).load(imageUrl).placeholder(R.drawable.plcimage).into(imageView);

        textViewTitle.setText(title);
        textViewReleaseDate.setText(releaseDate);
        textViewOverView.setText(overView);
        textViewVoteAverage.setText(String.valueOf (voteAverage) );





    }
}
