package com.amitraj.themoviedbapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by AmitRaj on 9/12/2017.
 */

public class ResponseMovieListModel {
    @SerializedName("results")
    @Expose
    private ArrayList<MovieListModel> results;

    public ArrayList<MovieListModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<MovieListModel> results) {
        this.results = results;
    }
}
