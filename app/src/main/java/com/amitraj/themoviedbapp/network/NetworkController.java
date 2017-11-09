package com.amitraj.themoviedbapp.network;

import com.amitraj.themoviedbapp.BaseApplication;
import com.amitraj.themoviedbapp.listner.NetworkResponseListner;
import com.amitraj.themoviedbapp.model.MovieDetailModel;
import com.amitraj.themoviedbapp.model.ResponseMovieListModel;
import com.amitraj.themoviedbapp.ui.BaseActivity;
import com.amitraj.themoviedbapp.ui.BaseFragment;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AmitRaj on 12-Sep-17.
 */

public class NetworkController {

    private BaseFragment baseContext;
    private BaseActivity baseActivity;

    public NetworkController(BaseFragment fragment) {
        this.baseContext = fragment;
    }

    public NetworkController(BaseActivity activity) {
        this.baseActivity = activity;
    }


    public void getMovieList(final NetworkResponseListner<ResponseMovieListModel> listner, String api_key) {
        baseContext.showProgressDialog();
        BaseApplication.getRetrofitAPI().getMovieList(api_key).enqueue(new Callback<ResponseMovieListModel>() {
            @Override
            public void onResponse(Call<ResponseMovieListModel> call, Response<ResponseMovieListModel> response) {
                baseContext.dismissProgressDialog();

                if (response != null && response.body() != null) {
                    listner.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseMovieListModel> call, Throwable t) {
                baseContext.dismissProgressDialog();
                baseContext.showServerError("Please try again !!!");
            }
        });
    }

    public void getMovieDetails(final NetworkResponseListner<MovieDetailModel> listner, String id,Map<String,String> api_key) {
        baseContext.showProgressDialog();
        BaseApplication.getRetrofitAPI().getMovieDetails(id,api_key).enqueue(new Callback<MovieDetailModel>() {
            @Override
            public void onResponse(Call<MovieDetailModel> call, Response<MovieDetailModel> response) {
                baseContext.dismissProgressDialog();

                if (response != null && response.body() != null) {
                    listner.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieDetailModel> call, Throwable t) {
                baseContext.dismissProgressDialog();
                baseContext.showServerError("Please try again !!!");
            }
        });
    }
}
