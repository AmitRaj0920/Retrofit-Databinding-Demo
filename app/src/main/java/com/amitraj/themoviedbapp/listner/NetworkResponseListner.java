package com.amitraj.themoviedbapp.listner;

/**
 * Created by AmitRaj on 12-Sep-17.
 */

public interface NetworkResponseListner<T> {
  void onResponse(T response);
}
