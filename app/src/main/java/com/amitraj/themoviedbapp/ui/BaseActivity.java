package com.amitraj.themoviedbapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.amitraj.themoviedbapp.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity extends AppCompatActivity {

  private ProgressDialog mProgressDialog;

  @Override public void onCreate(@Nullable Bundle savedInstanceState,
      @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
  }

  @Override protected void attachBaseContext(Context context) {
    try {
      super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void addFragment(BaseFragment fragment, String tag) {
    getSupportFragmentManager().beginTransaction().add(R.id.container, fragment, tag).commit();
  }

  public void showProgressDialog() {
    if (mProgressDialog != null && mProgressDialog.isShowing()) {
      return;
    }
    Log.i("ProgressDialog", "showProgressDialog");
    try {
      mProgressDialog = new ProgressDialog(this, R.style.TransparentProgressDialog);
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
  public void showServerError(String msg) {
    try {
      AlertDialog.Builder builder = new AlertDialog.Builder(this);
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

}