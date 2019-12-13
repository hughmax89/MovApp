package com.hgs.movapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hgs.domain.core.Movie;
import com.hgs.movapp.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private final List<Movie> dataList;
    private List<Movie> mFilteredList;
    private Context mContext;
    private final LayoutInflater inflater;

    public MovieListAdapter(Context context, List<Movie> dataList) {
        this.dataList = dataList;
        mFilteredList = dataList;
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_movie, parent, false);
        return new MovieListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder itemViewHolder = (MyViewHolder) holder;

        Movie current = dataList.get(position);

        String title = current.getTitle();
        itemViewHolder.title.setText(title);

        String description = current.getRelease_date();
        itemViewHolder.description.setText(description);

        String year = current.getRelease_date();
        itemViewHolder.year.setText(year);

        if (current.getPoster_path() != null && !current.getPoster_path().isEmpty()) {
            if (current.getPoster_path().contains("http")) {
                Picasso.with(mContext)
                        .load(current.getPoster_path())
                        .fit()
                        .placeholder(R.drawable.retro_tv_64px)
                        .centerCrop()
                        .into(itemViewHolder.poster);
            }
            else {
                Picasso.with(mContext)
                        .load(new File(current.getPoster_path()))
                        .fit()
                        .placeholder(R.drawable.retro_tv_64px)
                        .centerCrop()
                        .into(itemViewHolder.poster);
            }
        }
        else {
            Picasso.with(mContext)
                    .load(R.drawable.retro_tv_64px)
                    .placeholder(R.drawable.retro_tv_64px)
                    .into(itemViewHolder.poster);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public List<Movie> getFilteredList() {
        return dataList;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        final ImageView poster;
        final TextView title;
        final TextView description;
        final TextView year;

        public MyViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.image_movie);
            title = itemView.findViewById(R.id.name_movie);
            description = itemView.findViewById(R.id.description_movie);
            year = itemView.findViewById(R.id.year_movie);
        }

    }


}
