package com.amitraj.themoviedbapp.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amitraj.themoviedbapp.R;
import com.amitraj.themoviedbapp.databinding.FragmentMovieListBinding;
import com.amitraj.themoviedbapp.listner.NetworkResponseListner;
import com.amitraj.themoviedbapp.listner.OnListItemClickListner;
import com.amitraj.themoviedbapp.model.MovieListModel;
import com.amitraj.themoviedbapp.model.ResponseMovieListModel;
import com.amitraj.themoviedbapp.network.NetworkController;
import com.amitraj.themoviedbapp.ui.BaseFragment;
import com.amitraj.themoviedbapp.ui.adapter.MovieListAdapter;

import java.util.ArrayList;

/**
 * Created by AmitRaj on 9/12/2017.
 */

public class FragmentMoviesList extends BaseFragment implements NetworkResponseListner<ResponseMovieListModel>, OnListItemClickListner {
    public FragmentMoviesList() {
    }

    public static FragmentMoviesList newInstance() {
        Bundle args = new Bundle();
        FragmentMoviesList fragment = new FragmentMoviesList();
        fragment.setArguments(args);
        return fragment;
    }

    FragmentMovieListBinding mBinding;
    ArrayList<MovieListModel> arrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NetworkController controller = new NetworkController(this);
        controller.getMovieList(this, "b7cd3340a794e5a2f35e3abb820b497f");

    }

    @Override
    public void onResponse(ResponseMovieListModel response) {
        arrayList = response.getResults();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mBinding.recycleMovieList.setLayoutManager(linearLayoutManager);
        mBinding.recycleMovieList.setHasFixedSize(true);
        MovieListAdapter adapter = new MovieListAdapter(getActivity(), arrayList);
        adapter.setOnItemClickListener(this);
        mBinding.recycleMovieList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("movieId",arrayList.get(position).getId());
        replaceFragment(FragmentMovieDetails.newInstance(bundle),"FragmentMovieDetails-FragmentMoviesList");
    }
}
