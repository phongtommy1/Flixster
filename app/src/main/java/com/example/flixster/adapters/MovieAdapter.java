package com.example.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.media.Image;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import org.w3c.dom.Text;

import java.util.List;

public class MovieAdapter extends  RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    // inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movies, parent, false);
        return new ViewHolder(movieView);
    }

    // population of the data in the layout
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Log.d("MovieAdapter", "onBindViewHolder" + position);
        // get the movie at the position
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    // return total count of item in the list
    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvOverView;
        ImageView tvPoster;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOverView = itemView.findViewById(R.id.tvOverView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverView.setText(movie.getOverView());
            String imageURL;

            if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                imageURL = movie.getBackdropPath();
            }
            else{
                imageURL = movie.getPosterPath();
            }
            Glide.with(context).load(imageURL).into(tvPoster);
        }
    }
}
