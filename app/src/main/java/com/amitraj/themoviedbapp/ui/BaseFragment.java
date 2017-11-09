package com.amitraj.themoviedbapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.amitraj.themoviedbapp.R;


/**
 * Created by AmitRaj on 12-Sep-17.
 */

public class BaseFragment extends Fragment {

  private ProgressDialog mProgressDialog;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }


  @Override public void onDestroy() {
    super.onDestroy();
  }

  public void showProgressDialog() {
    if (mProgressDialog != null && mProgressDialog.isShowing()) {
      return;
    }
    Log.i("ProgressDialog", "showProgressDialog");
    try {
      mProgressDialog = new ProgressDialog(getActivity(), R.style.TransparentProgressDialog);
      mProgressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
      mProgressDialog.setCancelable(false);
      mProgressDialog.setIndeterminate(true);
      mProgressDialog.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void dismissProgressDialog() {
    if (mProgressDialog != null) {
      if (!mProgressDialog.isShowing()) {
        return;
      }
      Log.i("ProgressDialog", "dismissProgressDialog");
      try {
        mProgressDialog.dismiss();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void showServerError() {
    try {
      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      builder.setTitle("Network Error");
      builder.setMessage(
          "Unable to connect to server, please check your internet connection and try again.");
      builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialogInterface, int i) {
          dialogInterface.dismiss();
        }
      }).create().show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void showServerError(String msg) {
    try {
      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      builder.setMessage(msg);
      builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialogInterface, int i) {
          dialogInterface.dismiss();
        }
      }).create().show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void replaceFragment(BaseFragment fragment, String tag) {
    getFragmentManager().beginTransaction()
        .replace(R.id.container, fragment, tag)
        .addToBackStack(tag)
        .commit();
  }

  protected void storeBoolean(String key, Boolean value){
    SharedPreferences
        pref = getActivity().getApplicationContext().getSharedPreferences("hicare_pref", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = pref.edit();
    editor.putBoolean(key, value);
    editor.commit();
  }

  protected Boolean getBoolean(String key, Boolean defauleValue) {
    SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("hicare_pref", Context.MODE_PRIVATE);
    return pref.getBoolean(key, defauleValue);
  }

//  protected void logout(){
//    SharedPreferencesUtility.savePrefBoolean(getActivity(),
//        SharedPreferencesUtility.IS_USER_LOGIN, false);
//
//    Intent intent = new Intent(getActivity(), LoginMediUpdateActivity.class);
//    startActivity(intent);
//    getActivity().finish();
//  }
}
