package com.example.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
   Context ctx;
   List<ResultsItem> resultsItems;

    public MoviesAdapter(Context ctx, List<ResultsItem> resultsItems) {
        this.ctx = ctx;
        this.resultsItems = resultsItems;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(ctx).inflate(R.layout.movie_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
//holder.img.setImageResource();
        String posterPrefix="https://image.tmdb.org/t/p/w500/";
        Picasso.Builder builder = new Picasso.Builder(ctx);
        builder.downloader(new OkHttp3Downloader(ctx));
        builder.build().load(posterPrefix+resultsItems.get(position).getPosterPath())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return resultsItems.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}
