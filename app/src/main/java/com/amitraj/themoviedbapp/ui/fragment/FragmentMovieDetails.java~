package com.amitraj.themoviedbapp.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.amitraj.themoviedbapp.R;
import com.amitraj.themoviedbapp.databinding.FragmentMovieDetailsBinding;
import com.amitraj.themoviedbapp.listner.ButtonClickListener;
import com.amitraj.themoviedbapp.listner.NetworkResponseListner;
import com.amitraj.themoviedbapp.model.MovieDetailModel;
import com.amitraj.themoviedbapp.network.NetworkController;
import com.amitraj.themoviedbapp.ui.BaseFragment;
import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AmitRaj on 16-Sep-17.
 */

public class FragmentMovieDetails extends BaseFragment implements NetworkResponseListner<MovieDetailModel>,ButtonClickListener{
    public FragmentMovieDetails(){}
    public static FragmentMovieDetails newInstance(Bundle args) {
        FragmentMovieDetails fragment = new FragmentMovieDetails();
        fragment.setArguments(args);
        return fragment;
    }
    FragmentMovieDetailsBinding mBinding;
    String movieId;
//    ArrayList<MovieListModel> arrayList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details,container,false);
        mBinding.setHandler(this);
        return mBinding.getRoot();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() !=null){
            movieId=getArguments().getString("movieId");
        }
        Map<String,String> map = new HashMap<>();
        map.put("api_key","b7cd3340a794e5a2f35e3abb820b497f");
//        String path = movieId+getString(R.string.urlamp)+"api_key=b7cd3340a794e5a2f35e3abb820b497f";
        NetworkController controller = new NetworkController(this);
        controller.getMovieDetails(this,movieId,map);
    }

    @Override
    public void onResponse(MovieDetailModel response) {
        mBinding.setModel(response);
        float stars = (float) response.getPopularity()/100;
        mBinding.ratingBar.setRating(stars);
        Glide.with(getActivity())
                .load("https://image.tmdb.org/t/p/w500/"+response.getPoster_path())
//                .placeholder(R.mipmap.ic_launcher) // optional
//                .error(R.mipmap.ic_launcher)         // optional
                .fitCenter()
                .into(mBinding.imageView);
    }

    @Override
    public void onDevelopedByClickListner() {
        replaceFragment(FragmentDevelopedBy.newInstance(),"FragmentDevelopedBy-FragmentMovieDetails");
    }
}
