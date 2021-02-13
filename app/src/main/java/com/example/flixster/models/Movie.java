package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overView;

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        overView = jsonObject.getString("overview");
        title = jsonObject.getString("title");
    }

    public static List<Movie> fromJSONArray(JSONArray movieJSONArray) throws JSONException {
        List<Movie> a = new ArrayList<Movie>();
        for(int i = 0; i < movieJSONArray.length(); i++){
            // feteching movieJSONArray from result and indexing using getJSONObject
            a.add(new Movie(movieJSONArray.getJSONObject(i)));
        }

        return a;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }
    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }
}
