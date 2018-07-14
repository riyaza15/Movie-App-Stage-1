package com.example.riyaza.movieapp;

public class Movie {
    private String title;
    private String releaseDate;
    private  String overView;
    private String posterUrl;
    private double voteAverage;

    public Movie(){
    }

    public Movie(String title,String releaseDate,String overView, String posterUrl, double voteAverage){
        this.title= title;
        this.releaseDate=releaseDate;
        this.overView= overView;
        this.posterUrl=posterUrl;
        this.voteAverage=voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverView() {
        return overView;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public double getVoteAverage() {
        return voteAverage;
    }
}
