package com.example.riyaza.movieapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Tutorial followed Android Basic Networking course

    public static final String LOG_TAG = MainActivity.class.getName();
    private MovieAdapter movieAdapter;
    private static final String POP_MOVIE_REQUEST_URL ="https://api.themoviedb.org/3/movie/popular?api_key=";
    private static final String TOP_MOVIE_REQUEST_URL ="https://api.themoviedb.org/3/movie/top_rated?api_key=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Movie> movies= new ArrayList<Movie>();

        movies.add(new Movie("aaa","ba","ca","da",10));
        movies.add(new Movie("aab","bb","cb","db",11));
        movies.add(new Movie("aac","bc","cc","dc",12));
        movies.add(new Movie("aad","bd","cd","dd",13));
        movies.add(new Movie("aaf","be","ce","de",14));

        //ArrayAdapter<String> itemAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,movieTitle);
        movieAdapter= new MovieAdapter(this,movies);

        GridView gridView=(GridView) findViewById(R.id.grid);

        gridView.setAdapter(movieAdapter);
       MovieAsyncTask task = new MovieAsyncTask();
        task.execute(POP_MOVIE_REQUEST_URL);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this,DetailActivity.class);
                Movie currentMovie= movies.get(position);

                String title=currentMovie.getTitle();
                String releaseDate=currentMovie.getReleaseDate();
                String overView=currentMovie.getOverView();
                String posterUrl=currentMovie.getPosterUrl();
                double voteAverage=currentMovie.getVoteAverage();

                intent.putExtra("Titel",title);
                intent.putExtra("ReleaseDate",releaseDate);
                intent.putExtra("OverView",overView);
                intent.putExtra("PosterUrl",posterUrl);
                intent.putExtra("VoteAverage",voteAverage);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id== (R.id.popular)){
            MovieAsyncTask task = new MovieAsyncTask();
            task.execute(POP_MOVIE_REQUEST_URL);
        }
        if(id== (R.id.top_rated)){
            MovieAsyncTask task = new MovieAsyncTask();
            task.execute(TOP_MOVIE_REQUEST_URL);
        }
        return super.onOptionsItemSelected(item);
    }
    private class MovieAsyncTask extends AsyncTask<String, Void, List<Movie>> {
        @Override
        protected List<Movie> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            List<Movie> result = QueryUtils.fetchMovieData(urls[0]);
            return result;
        }
        @Override
        protected void onPostExecute(List<Movie> data) {
            movieAdapter.clear();
            if (data != null && !data.isEmpty()) {
                movieAdapter.addAll(data);
            }

        }


    }


}
