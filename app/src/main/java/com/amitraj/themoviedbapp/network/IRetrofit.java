package com.amitraj.themoviedbapp.network;

import com.amitraj.themoviedbapp.model.MovieDetailModel;
import com.amitraj.themoviedbapp.model.ResponseMovieListModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by AmitRaj on 12-Sep-17.
 */

public interface IRetrofit {
  String BASE_URL = "https://api.themoviedb.org/3/movie/";

  @FormUrlEncoded
  @POST("upcoming")
  Call<ResponseMovieListModel> getMovieList(@Field("api_key") String api_key);

  @GET("{path}")
  Call<MovieDetailModel> getMovieDetails(@Path("path") String path,@QueryMap Map<String, String> filters);

}

