package com.jolpai.tmdb;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private ArrayList<Movies.Result> list;
    private Context mContext;

    public  MovieListAdapter (Context context, ArrayList<Movies.Result> list){
        this.list=list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_movie_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Movies.Result movie = list.get(position);

        viewHolder.getTxtTitle().setText("Title: " + movie.getTitle());
        viewHolder.getTxtOverview().setText("Overview: " +movie.getOverview());
        viewHolder.getTxtReleaseDate().setText("Release Date: " + movie.getRelease_date());
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w220_and_h330_face/"+movie.getPoster_path())
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.getPoster());
        //viewHolder.getPoster().setImageBitmap(null);
    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtTitle, txtOverview, txtReleaseDate;
        private final View view;
        private final ImageView poster;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            this.view=v;
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                    //Toast.makeText(MyApplication.getContext(),"clicked232",Toast.LENGTH_SHORT).show();
                }
            });
            txtTitle = v.findViewById(R.id.txtTitle);
            txtOverview = v.findViewById(R.id.txtOverview);
            txtReleaseDate = v.findViewById(R.id.txtReleaseDate);
            poster = v.findViewById(R.id.poster);
        }

        public View getView(){
            return view;
        }

        public TextView getTxtTitle() {
            return txtTitle;
        }

        public TextView getTxtReleaseDate() {
            return txtReleaseDate;
        }

        public TextView getTxtOverview() {
            return txtOverview;
        }

        public ImageView getPoster() {
            return poster;
        }



    }
}
