package com.amitraj.themoviedbapp.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amitraj.themoviedbapp.R;
import com.amitraj.themoviedbapp.databinding.RecyclerMovieListBinding;
import com.amitraj.themoviedbapp.listner.OnListItemClickListner;
import com.amitraj.themoviedbapp.model.MovieListModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by AmitRaj on 16-Sep-17.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewAgency> {
    private Context context;
    private ArrayList<MovieListModel> arrayList;
    private OnListItemClickListner onListItemClickListner;

    public MovieListAdapter(Context context, ArrayList<MovieListModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewAgency onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerMovieListBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.recycler_movie_list, parent, false);
        return new ViewAgency(mBinding);
    }

    @Override
    public void onBindViewHolder(ViewAgency holder, final int position) {
        MovieListModel movieListModel = arrayList.get(position);
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/" + movieListModel.getPoster_path())
                .centerCrop()
                .into(holder.mBinding.ivPosterMovie);

        if (movieListModel.isAdult()) {
            holder.mBinding.tvAdult.setText("A");
        } else {
            holder.mBinding.tvAdult.setText("U/A");
        }

        holder.mBinding.setModel(movieListModel);
        holder.mBinding.executePendingBindings();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListItemClickListner.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setOnItemClickListener(OnListItemClickListner onItemClickListener) {
        this.onListItemClickListner = onItemClickListener;
    }

    class ViewAgency extends RecyclerView.ViewHolder {
        private final RecyclerMovieListBinding mBinding;

        private ViewAgency(RecyclerMovieListBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }
    }
}
